package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.List;

 
public class NumberofIslands2 {
 
    public final static int[][] DIRECTIONS = {{0,-1}, {0, 1}, {-1,0}, {1, 0}};
    int m = 0, n = 0;
    int totalNode = 0;
    int roots[];
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> output = new ArrayList();
        this.m = m;
        this.n = n;
        
        roots = new int[m*n+1];
    
        for(int[] position : positions){
           int nodeId = getNodeId(position[0], position[1]);
           if(roots[nodeId] != 0) {
                output.add(totalNode);
                continue;
           }
           roots[nodeId] = nodeId;
           ++totalNode;
           countComponents(generateEdges(nodeId, position));
           output.add(totalNode);
        }
        return output;
    }
    
    int getNodeId(int x, int y){
        return n*x + y + 1;
    }
    
    List<int[]> generateEdges(int nodeId, int[] position){
         
        List<int[]> edges = new ArrayList();
        for(int i = 0; i<DIRECTIONS.length; i++) {
            int x = position[0] + DIRECTIONS[i][0];
            int y = position[1] + DIRECTIONS[i][1];
             int adjacentNodeId = getNodeId(x, y);
            if(!isValidNode( x, y, adjacentNodeId)) continue;
            edges.add(new int[]{nodeId, adjacentNodeId});
         
        }
        return edges;
    }
    boolean isValidNode(int x, int y,  int adjacentNodeId){
        return (x >= 0 && x <m && y>=0 && y<n && roots[adjacentNodeId]!=0);
    }
  

    public int countComponents(List<int[]> edges) {
   
        for (int[] edge : edges) {
        
            int r1 = findRoot(edge[0]);
            int r2 = findRoot(edge[1]);

            if (r1 != r2) {
                roots[r1] = r2;
                totalNode--;
            }
        }

        return totalNode;
    }

    private int findRoot(int key) {
       
        if (key != roots[key]) {
            roots[key] = roots[roots[key]];
            key = roots[key];
            return findRoot(key);
        } else {
            return key;
        }
    }
}


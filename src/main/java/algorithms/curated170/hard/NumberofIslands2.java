package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.List;

 
public class NumberofIslands2 {
 
    public final static int[][] DIRECTIONS = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    int m = 0, n = 0;
    int totalNode = 0;
    int roots[];

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> output = new ArrayList<>();
        this.m = m;
        this.n = n;
        roots = new int[m * n + 1];

        for (int[] position : positions) {
            int nodeId = getNodeId(position[0], position[1]);
            if (roots[nodeId] != 0) {
                output.add(totalNode);
                continue;
            }

            roots[nodeId] = nodeId;
            ++totalNode;
            countComponents(nodeId, generateNeigbors(nodeId, position));
            output.add(totalNode);
        }
        return output;
    }

    int getNodeId(int x, int y) {
        return n * x + y + 1;
    }

    final int INVALID_VERTEX = -1;

    int[] generateNeigbors(int nodeId, int[] position) {
        int[] neighbors = new int[4];
        for (int i = 0; i < DIRECTIONS.length; i++) {
            int x = position[0] + DIRECTIONS[i][0];
            int y = position[1] + DIRECTIONS[i][1];
            int adjacentNodeId = getNodeId(x, y);

            if (!isValidNode(x, y, adjacentNodeId)) {
                neighbors[i] = INVALID_VERTEX;
                continue;
            }
            neighbors[i] = adjacentNodeId;
        }
        return neighbors;
    }

    boolean isValidNode(int x, int y, int adjacentNodeId) {
        return (x >= 0 && x < m && y >= 0 && y < n && roots[adjacentNodeId] != 0);
    }

    public int countComponents(int nodeId, int[] neigbors) {

        for (int neighbor : neigbors) {

            if (neighbor == INVALID_VERTEX) {
                continue;
            }
            int r1 = findRoot(nodeId);
            int r2 = findRoot(neighbor);

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

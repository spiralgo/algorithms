package algorithms;

import java.util.Arrays;
import java.util.Comparator; 
 
class DisjointSet
{
    private int[] parent = null;
  
    public int find(int k)
    {
       
        if (parent[k] != k)
        {
            parent[k] = find(parent[k]);
        }
 
        return parent[k];
    }
    
    int count;
  
    public void union(int a, int b)
    {
 
        int x = find(a);
        int y = find(b);
  
        if (x == y) {
            return;
        }
 
        count--;
       
 
          parent[x] = y;
            
       
    }
    
 
 
    public static void main(String[] args)
    {
          int[][] logs = {{3,0,3},{4,1,2},{0,2,0},{2,0,2},{8,0,3},{1,0,1},{5,1,2},{7,3,1},{6,1,0},{9,3,0}};
;
         DisjointSet ds = new DisjointSet();
         System.out.println("all friends" + ds.earliestAcq(logs, 4));
    }
    
        public int earliestAcq(int[][] logs, int N) {
             parent = new int[N];
              Arrays.sort(
                logs,
                new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
            return ((Integer) a[0]).compareTo(b[0]);

            }
        });
            
    
            for (int i = 0; i < N; i++) {
                   parent[i]= i; 
            }
         count = N; 
  
        for(int[] friendship: logs){
             union(friendship[1], friendship[2]);       
             
               if(count == 1){
           
                return friendship[0];
               } 
        }
         return -1;
        }
        
}
 
 


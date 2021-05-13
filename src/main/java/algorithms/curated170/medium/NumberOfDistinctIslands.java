package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    Set<String> islands;
    int[][] grid; 
    int xDim;
    int yDim;

    public int numDistinctIslands(int[][] grid)
    {
        this.grid = grid; 
        islands = new HashSet<>();
        xDim = grid.length;
        yDim = grid[0].length;

        for(int i = 0; i<xDim; i++)
        {
            for(int j = 0; j<yDim; j++)
            {
               islandCode = new StringBuilder();
                 DFS(i, j, "#");
                  if (islandCode.length() == 0) {
                    continue;
                }
                islands.add(islandCode.toString());
            }
        }

        return islands.size();
    }

    StringBuilder islandCode = new StringBuilder();
    private void DFS(int i, int j, String dir)
    {
      if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;    
            
          grid[i][j] = 0;
       
           islandCode.append(dir);
            DFS(i+1, j, "d");
            DFS(i-1, j, "u");
            DFS(i, j+1, "r");
            DFS(i, j-1, "l");
            islandCode.append("#");
    
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] { 
        { 1, 1, 1 },
        { 0, 1, 0 }, 
        { 0, 1, 0 },
        { 0, 0, 1 }, 
        { 0, 0, 1 },
        { 1, 1, 0 },
        { 1, 0, 1 },
        { 0, 1, 1 }, 
        { 1, 0, 0 } };

        int[][] grid2 = new int[][]
        {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}
        }; 

        int[][] grid3 = new int[][]
        {
            {1,1,1,1,1},
            {0,0,0,0,1},
            {1,1,0,0,1},
            {0,1,1,1,1}
        }; 

        System.out.println(Arrays.deepToString(grid));
        var solution = new NumberOfDistinctIslands();

        solution.numDistinctIslands(grid);
        System.out.println(solution.islands);

        solution.numDistinctIslands(grid2);
        System.out.println(solution.islands);

        solution.numDistinctIslands(grid3);
        System.out.println(solution.islands);
    }
}

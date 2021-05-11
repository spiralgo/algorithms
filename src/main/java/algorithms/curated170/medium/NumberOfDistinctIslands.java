package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    
    Set<String> islands;
    int[][] grid;
    int xDim;
    int yDim;
    public int numOfIslands(int[][] grid)
    {
        this.grid = grid;
        islands = new HashSet<>();
        xDim = grid.length;
        yDim = grid[0].length;

        for(int i = 0; i<xDim; i++)
        {
            for(int j = 0; j<yDim; j++)
            {
                String k = DFS(i, j);
                if(k!="#")
                {
                    islands.add(k);
                }
            }
        }
        System.out.println(islands);
        return islands.size();
    }
    
    private String DFS(int i, int j)
    {
        String islandCode = "";
        if(grid[i][j] == 0)
        {
            return "#";
        }
        grid[i][j] = 0;
        if(i<xDim-1&&grid[i+1][j] == 1)
        {
            islandCode += "d(";
            islandCode += DFS(i+1, j);
            islandCode += ")";
        }
        if(j<yDim-1&&grid[i][j+1] == 1)
        {
            islandCode += "r(";
            islandCode += DFS(i, j+1);
            islandCode += ")";
        }
        if(i>0&&grid[i-1][j] == 1)
        {
            islandCode += "u(";
            islandCode += DFS(i-1, j);
            islandCode += ")";
        }
        if(j>0&&grid[i][j-1] == 1)
        {
            islandCode += "l(";
            islandCode += DFS(i, j-1);
            islandCode += ")";
        }
        return islandCode;
    }


    public static void main(String[] args) {
        int[][] grid =  new int[][]{
            {1, 1, 1},
            {0, 1, 0},
            {0, 1, 0},
            {0, 0, 1},
            {0, 0, 1},
            {1, 1, 0},
            {1, 0, 1},
            {0, 1, 1},
            {1, 0, 0}
        };
        
        System.out.println(Arrays.deepToString(grid));
        var solution = new NumberOfDistinctIslands();
        solution.numOfIslands(grid);
    }
}

package algorithms.curated170.medium;

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

        for(int x = 0; x<xDim; x++)
        {
            for(int y = 0; y<yDim; y++)
            {
                String k = DFS(x, y);
                if(k!="#")
                {
                    islands.add(k);
                }
            }
        }
        System.out.println(islands);
        return islands.size();
    }
    
    private String DFS(int x, int y)
    {
        String islandCode = "";
        if(grid[x][y] == 0)
        {
            return "#";
        }
        grid[x][y] = 0;
        if(x<xDim-1&&grid[x+1][y] == 1)
        {
            islandCode += "r(";
            islandCode += DFS(x+1, y);
            islandCode += ")";
        }
        if(y<yDim-1&&grid[x][y+1] == 1)
        {
            islandCode += "u(";
            islandCode += DFS(x, y+1);
            islandCode += ")";
        }
        if(x>0&&grid[x-1][y] == 1)
        {
            islandCode += "l(";
            islandCode += DFS(x-1, y);
            islandCode += ")";
        }
        if(y>0&&grid[x][y-1] == 1)
        {
            islandCode += "d(";
            islandCode += DFS(x, y-1);
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
            {1, 0, 0},
            {1, 0, 0},
        };
        var solution = new NumberOfDistinctIslands();
        solution.numOfIslands(grid);
    }
}

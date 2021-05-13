package algorithms.curated170.medium.numberofdistinctislands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslandsCoordinates {

    Set<List<List<Integer>>> islands;
    int[][] grid;
    int xDim;
    int yDim;

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        islands = new HashSet<>();
        xDim = grid.length;
        yDim = grid[0].length;

        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                parent = new int[]{i,j};
                currIsland = new ArrayList<>();
                DFS(i, j);
                if(!currIsland.isEmpty())
                {
                    islands.add(currIsland);
                }
            }
        }

        return islands.size();
    }

    int[] parent;
    List<List<Integer>> currIsland;
    private void DFS(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return;

        grid[i][j] = 0;
        currIsland.add(List.of(i-parent[0], j-parent[1]));
        DFS(i + 1, j);
        DFS(i - 1, j);
        DFS(i, j + 1);
        DFS(i, j - 1);

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
            { 1, 0, 0 }, 
            { 1, 0, 0 }, 
            { 0, 1, 0 } };
    
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

        var solution = new NumberOfDistinctIslandsCoordinates();

        solution.numDistinctIslands(grid);
        System.out.println(solution.islands);
        /* [[[0, 0], [1, 0]], [[0, 0], [1, 0], [1, -1]], [[0, 0]],
           [[0, 0], [0, 1], [1, 1], [2, 1], [0, 2]], [[0, 0], [1, 0], [0, 1]]]        */

        solution.numDistinctIslands(grid2);
        System.out.println(solution.islands);
        // [[[0, 0], [1, 0], [1, 1], [0, 1]]]

        solution.numDistinctIslands(grid3);
        System.out.println(solution.islands);
        // [[[0, 0], [0, 1], [0, 2], [0, 3], [0, 4], [1, 4], [2, 4], [3, 4], [3, 3], [3, 2], [3, 1], [2, 1], [2, 0]]]
    }
}

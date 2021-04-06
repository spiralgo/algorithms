/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.medium;

/**
 *
 * @author Erdem
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}};
        numIslands(grid);
    }

    public static int numIslands(char[][] grid) {
         int row = grid.length;
         int column = grid[0].length;
        
         int count = 0;
         for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    gridDFS(grid, i, j);
                }
            }
        }
        return count;
    }

    static void gridDFS(char[][] grid, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;

    
       if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        gridDFS(grid, i - 1, j);

        gridDFS(grid, i + 1, j);

        gridDFS(grid, i, j - 1);

        gridDFS(grid, i, j + 1);

    }

}

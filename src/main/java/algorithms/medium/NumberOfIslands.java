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
    public static int solution(char[][]grid)
    {
        int count = 0;
        for(int i = 0; i<grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1')
                {
                    count++;
                    grid[i][j] = 0;
                    gridDFS(grid, i, j);
                }
            }
        }
        return  count;
    }
    static void gridDFS(char [][] grid, int i, int j)
    {
        if(grid[i][j] == '0')
        {
            return;
        }
        grid[i][j] = '0';
        if(i > 0)
        {
            gridDFS(grid, i-1, j);
        }
        if(i < grid.length-1)
        {
            gridDFS(grid, i+1, j);
        }
        if (j > 0) {
            gridDFS(grid, i, j-1);
        }
        if(j < grid[i].length-1)
        {
            gridDFS(grid, i, j+1);
        }
        
    }
    
}

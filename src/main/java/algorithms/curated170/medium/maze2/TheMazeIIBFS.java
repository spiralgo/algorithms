package algorithms.curated170.medium.maze2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

 
public class TheMazeIIBFS {
int[][] maze;

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        this.maze = maze;
        
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        distance[start[0]][start[1]] = 0;
        
        int[][] directions = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
        
        Queue <int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
           
            int[] s = queue.remove();
            
            for (int[] dir: directions) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while (canPass(x, y)) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                
                int prx = x - dir[0];
                int pry = y - dir[1];
                
                int total = distance[s[0]][s[1]] + count; 
                
                if ( total < distance[prx][pry]) {
                    distance[prx][pry] = total;
                    queue.add(new int[] {prx, pry});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
    
    boolean canPass(int nextX, int nextY) {
        return (nextX >= 0 && nextY >= 0
                && nextX < maze.length
                && nextY < maze[0].length
                && maze[nextX][nextY] == 0);

    }
}

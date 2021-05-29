package algorithms.curated170.medium.maze2;

import java.util.Arrays;
import java.util.PriorityQueue;

 
public class TheMazeIIDijkstra {
    final static int VISITED = -1;
    int[][] maze;
  public int shortestDistance(int[][] maze, int[] start, int[] dest) {
 
        this.maze = maze;
        
        return dijkstra(start, dest); 
    }
   
 public int dijkstra( int[] start, int[] destination) {
         
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]); 
        int[][] directions = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
     
        pq.add(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
        
            int[] startPoint = pq.poll();
             
            int x = startPoint[0];
            int y = startPoint[1];
            
            if(maze[x][y]==-1) continue;
            
            maze[x][y] = VISITED;   
            if (x == destination[0] && y == destination[1]) {
                return startPoint[2];
            }
           
       
           for (int[] dir: directions) {
                int dirx = dir[0];
                int diry = dir[1];
           
                int nextX = x;
                int nextY = y;
               
                int currentDistance =  startPoint[2];
                
                while (canPass(nextX, nextY)) {
                    nextX += dirx;
                    nextY += diry;
                    currentDistance++;
                }

                nextX -= dirx;
                nextY -= diry;
                currentDistance--;
           
                
                 if(maze[nextX][nextY]!=-1) {
                      
                      pq.add(new int[]{nextX, nextY, currentDistance});
                }
            }
        }
        return VISITED;
    }
 
     boolean canPass(int nextX, int nextY) {
            return (nextX >= 0 && nextY >= 0
                    && nextX < maze.length
                    && nextY < maze[0].length
                    && maze[nextX][nextY] != 1);

        }
}

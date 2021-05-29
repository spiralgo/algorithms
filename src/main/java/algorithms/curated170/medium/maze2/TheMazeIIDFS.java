package algorithms.curated170.medium.maze2;

import java.util.Arrays;

 
public class TheMazeIIDFS {
 
    
    int[][] maze;
    int[] destination;
    int[][] distance;
    
    int[][] directions = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
      
       this.maze = maze;
       this.destination = dest;
       this.distance = new int[maze.length][maze[0].length];
       
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        distance[start[0]][start[1]] = 0;
        
        dfs(start[0], start[1], -1);
        
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dfs(int x, int y, int arrivedFrom) {
        
         
        if (x == destination[0] && y == destination[1]) {
            return;
        }
        
     
        for (int i = 0; i<4; i++){
           
            if((i == 0 && arrivedFrom == 3)
                || (i == 1 && arrivedFrom == 2)
                || (i == 2 && arrivedFrom == 1)
                || (i == 3 && arrivedFrom == 0))
                {
                    continue;
                }

            int dirx = directions[i][0];
            int diry = directions[i][1];
           
            int nextX = x + dirx;
            int nextY = y + diry;
            
            int count = 0;
            
           while (canPass(nextX, nextY) ) {
             
                nextX += dirx;
                nextY += diry;
                count++;
            }
            
                int prx = nextX - dirx;
                int pry = nextY - diry;
                
                int total = distance[x][y] + count; 
                
                if (total < distance[prx][pry]) {
                     
                      distance[prx][pry] = total;
                      dfs(prx, pry, i);
                }
          
        }
    }
      boolean canPass(int nextX, int nextY) {
        return (nextX >= 0 && nextY >= 0
                && nextX < maze.length
                && nextY < maze[0].length
                && maze[nextX][nextY] == 0);

    }
 
}

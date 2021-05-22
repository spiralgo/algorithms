package algorithms.curated170.medium.maze2;

import java.util.Arrays;
import java.util.PriorityQueue;

 
public class TheMazeIIDijkstra {
 
    int[][] maze;
    int[] destination;
    int[][] distance;
  
    boolean visited[][];
    
    int[][] directions = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
    
  public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        this.distance = new int[maze.length][maze[0].length];
        this.destination = dest;
        this.visited = new boolean[maze.length][maze[0].length];
        this.maze = maze;

        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        distance[start[0]][start[1]] = 0;
    
        pq.add(new int[]{start[0], start[1], 0});
        
        dijkstra();

        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
   
    public int[] minDistance() {
        int[] min={-1,-1};
        int min_val = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                if (!visited[i][j] && distance[i][j] < min_val) {
                    min = new int[] {i, j};
                    min_val = distance[i][j];
                }
            }
        }
        return min;
    }
  
    PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]); 

    
    public void dijkstra() {
     
        while (!pq.isEmpty()) {
        
            int[] s = pq.poll();
           
            if (s[0] < 0)
                break;
            
            int x = s[0];
            int y = s[1];
                  
            if (x == destination[0] && y == destination[1]) {
                return;
            }
            visited[x][y] = true;
            
            for (int i = 0; i<4; i++){
                int dirx = directions[i][0];
                int diry = directions[i][1];
           
                int nextX = s[0] + dirx;
                int nextY = s[1] + diry;
                int count = 0;
                while (canPass(nextX, nextY)) {
                    nextX += dirx;
                    nextY += diry;
                    count++;
                }
                int prx = nextX - dirx;
                int pry = nextY - diry;
                
                int total = distance[x][y] + count; 
                
                if (total < distance[prx][pry]) {
                     
                      distance[prx][pry] = total;
                      pq.add(new int[]{prx, pry, total});
                }
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

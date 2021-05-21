package algorithms;
  
import java.util.HashMap;
import org.apache.commons.lang3.tuple.Pair;

 
public class Playground {
 
    public static void main(String[] args) {
        Playground theMaze = new Playground();
        int[][] maze = {{0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}};

        int[] start = {0, 4}, destination = {4, 4};
        int result = theMaze.shortestDistance(maze, start, destination);
        System.out.println(result);
    }
    boolean visited[][];
     
    int[][] directions = {{0, -1}, {1, 0},{0, 1}, {-1, 0}};
    int[][] maze;
    int[] destination;
 
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
     
      visited = new boolean[maze.length][maze[0].length];
        this.maze = maze;
        this.destination = destination;

          dps(start[0], start[1]);  
          return currentMin;
    }
    int currentMin = Integer.MAX_VALUE;
    
    int i = 0;
    int total = 0;
    void dps(int x, int y) {
        
        System.out.println(++i);
        if (x == destination[0] && y == destination[1]) {
            total = 0;
            
            currentMin =  Math.min(currentMin, total);
        }
       
        visited[x][y] = true; 
        
        for (int i = 0; i < directions.length; i++) {
            int dirx = directions[i][0];
            int diry = directions[i][1];
            int nextX = x + dirx;
            int nextY = y + diry;

            while (canPass(nextX, nextY)
                    && !visited[nextX][nextY]) {
                int prx = nextX;
                int pry = nextY;
                total++;
                System.out.println(getDirStr(dirx, diry));
                System.out.println("total:" + total + " " + System.currentTimeMillis()+ "  nextX:" + nextX + " nextY:" + nextY);

                nextX += dirx;
                nextY += diry;
              
                if(!canPass(nextX, nextY)){
                     System.out.println("total:" + total + " " + System.currentTimeMillis() + "  prx:" + prx + " pry:" + pry);
                     dps(prx, pry);
                   
                }
                
           
            }
       }
      
    }
    String getDirStr(int x, int y){
       
        if(x == 0){
             if(y== -1) return "left";
             return "right";
        }
        if(x== -1) return "up";
             return "down";
  
    }
    boolean canPass(int nextX, int nextY) {
        return (nextX >= 0 && nextY >= 0
                && nextX < maze.length
                && nextY < maze[0].length
                && maze[nextX][nextY] == 0);

    }
}


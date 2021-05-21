package algorithms.curated170.medium.maze;

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeBFS {

    public static void main(String[] args) {
        TheMazeBFS theMaze = new TheMazeBFS();
        int[][] maze = {{0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 0, 0, 0}};

        int[] start = {0, 4}, destination = {4, 4};
        boolean result = theMaze.hasPath(maze, start, destination);
        System.out.println(result);
    }
    int[][] directions = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
    int[][] maze;

    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        this.maze = maze;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
            for (int[] d : directions){
                  int dirx = d[0];
                  int diry = d[1];
                  int nextX = cur[0] + dirx;
                  int nextY = cur[1] + diry;
               
                while(canPass(nextX, nextY)){
                    nextX += d[0];
                    nextY += d[1];
                }
                nextX -= d[0];
                nextY -= d[1];
                if (!visited[nextX][nextY]){
                    q.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return false;
    }
    boolean canPass(int nextX, int nextY) {
        return (nextX >= 0 && nextY >= 0
                && nextX < maze.length
                && nextY < maze[0].length
                && maze[nextX][nextY] == 0);

    }
}

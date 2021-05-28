package algorithms.curated170.medium.maze;

public class TheMazeDFS {

    public static void main(String[] args) {
        TheMazeDFS theMaze = new TheMazeDFS();
        int[][] maze = {{0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 0, 0, 0}};

        int[] start = {0, 4}, destination = {4, 4};
        boolean result = theMaze.hasPath(maze, start, destination);
        System.out.println(result);
    }
    boolean visited[][];
    int[][] directions = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
    int[][] maze;
    int[] destination;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        this.maze = maze;
        this.destination = destination;

        return dfs(start[0], start[1], -1);
    }

public boolean dfs(int x, int y, int arrivedFrom) {

        if (x == destination[0] && y == destination[1]) {
            return true;
        }

        visited[x][y] = true;
        boolean result = false;

           for (int i = 0; i<4; i++){
               
              
            if((i == 0 && arrivedFrom == 3)
            ||(i == 1 && arrivedFrom == 2)
            || (i == 2 && arrivedFrom == 1)
            || (i == 3 && arrivedFrom == 0))
            {
                continue;
            }
            int dirx = directions[i][0];
            int diry = directions[i][1];
            int nextX = x + dirx;
            int nextY = y + diry;

            while (canPass(nextX, nextY)
                    && !visited[nextX][nextY]) {
                int prx = nextX;
                int pry = nextY;
                nextX += dirx;
                nextY += diry;
                result = result || !canPass(nextX, nextY) && dfs(prx, pry, i);

            }
       }

        return result;
    }
    boolean canPass(int nextX, int nextY) {
        return (nextX >= 0 && nextY >= 0
                && nextX < maze.length
                && nextY < maze[0].length
                && maze[nextX][nextY] == 0);

    }
}

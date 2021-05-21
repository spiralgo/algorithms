package algorithms.curated170.medium;

public class TheMaze {

    public static void main(String[] args) {
        TheMaze theMaze = new TheMaze();
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

        return dfs(start[0], start[1]);
    }

    public boolean dfs(int x, int y) {

        if (x == destination[0] && y == destination[1]) {
            return true;
        }

        visited[x][y] = true;
        boolean result = false;

        for (int i = 0; i < directions.length; i++) {
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
                result = result || (!canPass(nextX, nextY) && dfs(prx, pry));

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

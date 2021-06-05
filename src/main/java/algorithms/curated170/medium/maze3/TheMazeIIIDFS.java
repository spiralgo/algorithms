package algorithms.curated170.medium.maze3;

import java.util.Arrays;

public class TheMazeIIIDFS {
   
    int min;
    StringBuilder minS;
    int[] hole;
    int[][] maze;
    int[][] map;
    final int[][] directions = { { 0, 1 }, { -1, 0 }, { 1, 0 }, { 0, -1 } };
    final char[] directionSymbols = { 'r', 'u', 'd', 'l' };

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        this.min = Integer.MAX_VALUE;
        this.minS = null;
        this.hole = hole;
        this.maze = maze;
        this.map = new int[maze.length][maze[0].length];

        for (int[] row : map) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        move(ball[0], ball[1], 0, new StringBuilder(""), -1);

        return (minS == null) ? "impossible" : minS.toString();
    }

    private void move(int x, int y, int cnt, StringBuilder path, int dir) {
        if (cnt > min || cnt > map[x][y]) {
            return;
        }

        StringBuilder newPath = new StringBuilder(path);
        if (dir != -1) {

            newPath.append(directionSymbols[dir]);

            while (canPass(x, y)) {
                map[x][y] = Math.min(map[x][y], cnt);

                if (checkTargetReached(x, y, cnt, newPath)) {
                    return;
                }
                x += directions[dir][0];
                y += directions[dir][1];
                cnt++;
            }
            x -= directions[dir][0];
            y -= directions[dir][1];
            cnt--;
        }

        moveToFourDirections(x, y, cnt, newPath, dir);
    }

    private boolean canPass(int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

    private boolean checkTargetReached(int x, int y, int cnt, StringBuilder path) {
        if (x == hole[0] && y == hole[1]) {

            if (cnt == min && path.compareTo(minS) < 0) {
                minS = path;
            } else if (cnt < min) {
                min = cnt;
                minS = path;
            }
            return true;
        }

        return false;
    }

    private void moveToFourDirections(int x, int y, int cnt, StringBuilder path, int dir) {
        for (int i = 0; i < 4; i++) {

            if (isInvalidDestination(dir, i)) {
                continue;
            }

            int newR = x + directions[i][0];
            int newC = y + directions[i][1];
            if (canPass(newR, newC)) {
                move(x, y, cnt, path, i);
            }
        }
    }

    private boolean isInvalidDestination(int dir, int dest) {
        return (dir == dest || (dir == (3 - dest)));
    }
}

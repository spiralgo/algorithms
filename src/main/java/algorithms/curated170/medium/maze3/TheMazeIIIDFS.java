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
        for (int i = 0; i < map.length; i++)
            Arrays.fill(map[i], Integer.MAX_VALUE);

        // At the beginning, we are at the given position, where path length = 0, path
        // string is empty, and our initial direction is none(-1)
        move(ball[0], ball[1], 0, new StringBuilder(""), -1);
        return (minS == null) ? "impossible" : minS.toString();
    }

    private void move(int x, int y, int cnt, StringBuilder path, int dir) {
        if (cnt > min || cnt > map[x][y])
            return;

        StringBuilder newPath = new StringBuilder(path);
        if (dir != -1) {

            // values of dir correspond to various chars, we add these chars in relation to
            // the direction we came from
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

            // if path lengths are equal and the new one is lexographically smaller
            if (cnt == min && path.compareTo(minS) < 0) {
                minS = path;
            }
            // if the path length is smaller
            else if (cnt < min) {
                min = cnt;
                minS = path;
            }
            return true;
        }

        return false;
    }

    private void moveToFourDirections(int x, int y, int cnt, StringBuilder path, int dir) {
        for (int i = 0; i < 4; i++) {

            /*
             * This doesn't effect the result of the algorithm bu it makes it faster,
             * because: It doesn't make sense to go in the direction by which we arrived
             * from. For example, if we have arrived from right, we can't go further right,
             * because we have hit a wall and that is why we have stopped at this tile in
             * the first place.
             */
            if (dir == i)
                continue;

            /*
             * Second, this line tries to do something similar but in an other way. The only
             * possible way this if statement can be true is that dir == 0 and i == 3 In
             * other words, if we came from right and are trying to go left
             */

            if (dir == (3 - i))
                continue;

            /*
             * Unlike in our previous solutions of Maze 2 and Maze 1, we move to the valid
             * adjacenet tiles of a stable vertex, not to another stable vertex
             */
            int newR = x + directions[i][0];
            int newC = y + directions[i][1];
            if (canPass(newR, newC)) {
                move(x, y, cnt, path, i);
            }
        }
    }
    }
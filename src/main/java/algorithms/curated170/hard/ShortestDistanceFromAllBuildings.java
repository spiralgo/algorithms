package algorithms.curated170.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestDistanceFromAllBuildings {

    private static int[] dir = { -1, 0, 1, 0, -1 };

    private int m, n;

    public int shortestDistance(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int visitCount = 0;
        int minDist = 0;

        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minDist = helper(grid, i, j, visitCount, dist);
                    if (minDist == Integer.MAX_VALUE)
                        return -1;
                    visitCount++;
                }
            }

        return minDist;
    }

    private int helper(int[][] grid, int i, int j, int visitCount, int[][] dist) {

        int minDist = Integer.MAX_VALUE;

        Deque<int[]> tiles = new ArrayDeque<>();
        tiles.add(new int[] { i, j });
        int layer = 0;

        while (!tiles.isEmpty()) {
            int levelSize = tiles.size();

            layer++;
            while (levelSize --> 0) {
                int[] t = tiles.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = t[0] + dir[k];
                    int ny = t[1] + dir[k + 1];
                    if (!outOfRangeOrVisited(nx, ny, grid, visitCount)) {
                        dist[nx][ny] += layer;
                        grid[nx][ny]--;
                        tiles.add(new int[] { nx, ny });

                        minDist = Math.min(minDist, dist[nx][ny]);
                    }
                }
            }
        }

        return minDist;
    }

    private static final int INVERT_NEGATIVE_COUNT = -1;

    private boolean outOfRangeOrVisited(int nx, int ny, int[][] grid, int visitCount) {
        return nx == m || nx == -1 || ny == -1 || ny == n || INVERT_NEGATIVE_COUNT * grid[nx][ny] != visitCount;
    }

    public static void main(String[] args) {
        var solution = new ShortestDistanceFromAllBuildings();
        int[][] grid = { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
        System.out.println(solution.shortestDistance(grid));
    }
}

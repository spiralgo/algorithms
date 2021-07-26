package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceFromAllBuildings {

    int m, n;
    int[][] grid;
    int[][] count;

    public int shortestDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        count = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    BFS(i, j, new int[m][n], 0);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    min = Math.min(min, count[i][j]);
            }
        }

        return min;
    }

    void BFS(int a, int b, int[][] dist, int total) {
        if (noVisit(a, b, dist, total)) {
            return;
        }
        count[a][b] -= dist[a][b];
        count[a][b] += (dist[a][b] = total);

        BFS(a + 1, b, dist, total + 1);
        BFS(a - 1, b, dist, total + 1);
        BFS(a, b + 1, dist, total + 1);
        BFS(a, b - 1, dist, total + 1);
    }

    private boolean noVisit(int a, int b, int[][] dist, int total) {
        return a == m || a == -1 || b == -1 || b == n || grid[a][b] != 0 || (dist[a][b] != 0 &&  dist[a][b] < total);
    }

    public static void main(String[] args) {
        var solution = new ShortestDistanceFromAllBuildings();
        int[][] grid = { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
        System.out.println(solution.shortestDistance(grid));
    }
}

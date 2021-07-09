package algorithms.curated170.hard;

import java.util.Arrays;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        return findDistance(row) + findDistance(col);
    }

    private int findDistance(int[] array) {
        int s = 0;
        int e = array.length - 1;
        int moves = 0;

        while (s < e) {
            if (array[s] <= array[e]) {
                moves += array[s] * (e - s);
                array[e] -= array[s++];
            } else {
                moves += array[e] * (e - s);
                array[s] -= array[e--];
            }

        }
        return moves;
    }
}

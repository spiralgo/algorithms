package algorithms.curated170.hard.rangesumquery2dmutable;

public class RangeSumQuery2DMutableSegmentTree {

    class NumMatrix {
        private int m;
        private int n;
        private int[][] bit;

        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;

            // Using 1-based indexing
            bit = new int[m + 1][];

            for (int i = 1; i <= m; i++) {
                bit[i] = new int[n + 1];
            }

            buildBit(matrix);
        }

        public void update(int row, int col, int val) {
            int oldVal = sumRegion(row, col, row, col);
            int diff = val - oldVal;

            // Increment for 1-based indexing
            row++;
            col++;

            updateBit(row, col, diff);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // Increment for 1-based indexing
            row1++;
            col1++;
            row2++;
            col2++;

            int a = queryBit(row2, col2);
            int b = queryBit(row1 - 1, col1 - 1);
            int c = queryBit(row2, col1 - 1);
            int d = queryBit(row1 - 1, col2);

            return (a + b) - (c + d);
        }

        private int lsb(int i) {
            return i & (-i);
        }

        private void buildBit(int[][] matrix) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int val = matrix[i - 1][j - 1];
                    updateBit(i, j, val);
                }
            }
        }

        private void updateBit(int r, int c, int val) {
            for (int i = r; i <= m; i += lsb(i)) {
                for (int j = c; j <= n; j += lsb(j)) {
                    bit[i][j] += val;
                }
            }
        }

        private int queryBit(int r, int c) {
            int sum = 0;

            for (int i = r; i > 0; i -= lsb(i)) {
                for (int j = c; j > 0; j -= lsb(j)) {
                    sum += bit[i][j];
                }
            }

            return sum;
        }
    }
}

package algorithms.curated170.hard.rangesumquery2dmutable;

public class RangeSumQuery2DMutableBIT {

    class NumMatrix {
        
        private int m;
        private int n;
        private int[][] bit;
        private int[][] mat;

        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            this.mat = matrix;

            bit = new int[m + 1][];

            for (int i = 1; i <= m; i++) {
                bit[i] = new int[n + 1];
            }

            buildBIT(matrix);
        }

        public void update(int row, int col, int val) {
            int oldVal = mat[row][col];
            int diff = val - oldVal;
            
            updateBIT(row+1, col+1, diff);
            mat[row][col] = val;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            row1++;
            col1++;
            row2++;
            col2++;

            int a = queryBIT(row2, col2);
            int b = queryBIT(row1 - 1, col1 - 1);
            int c = queryBIT(row2, col1 - 1);
            int d = queryBIT(row1 - 1, col2);

            return (a + b) - (c + d);
        }

        private int lsb(int i) {
            return i & (-i);
        }

        private void buildBIT(int[][] matrix) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int val = matrix[i - 1][j - 1];
                    updateBIT(i, j, val);
                }
            }
        }

        private void updateBIT(int r, int c, int val) {
            for (int i = r; i <= m; i += lsb(i)) {
                for (int j = c; j <= n; j += lsb(j)) {
                    bit[i][j] += val;
                }
            }
        }

        private int queryBIT(int r, int c) {
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

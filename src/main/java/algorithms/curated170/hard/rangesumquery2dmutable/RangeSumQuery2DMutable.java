package algorithms.curated170.hard.rangesumquery2dmutable;

public class RangeSumQuery2DMutable {

    class NumMatrix {
        
        private int[][] colSums;
        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            
            int m = matrix.length;
            int n = matrix[0].length;
            colSums = new int[m + 1][n];
            
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < n; j++) {
                    colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
                }
            }
        }

        public void update(int row, int col, int val) {
            for (int i = row + 1; i < colSums.length; i++) {
                colSums[i][col] += (val - matrix[row][col]);
            }

            matrix[row][col] = val;
        }


        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;

            for (int j = col1; j <= col2; j++) {
                sum += colSums[row2 + 1][j] - colSums[row1][j];
            }

            return sum;
        }
    }

}

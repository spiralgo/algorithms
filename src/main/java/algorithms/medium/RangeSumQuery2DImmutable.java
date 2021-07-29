package algorithms.medium;

public class RangeSumQuery2DImmutable {
    
    public class NumMatrix {

        int[][] sum;

        public NumMatrix(int[][] matrix) {

            int rows = matrix.length, cols = matrix[0].length;
            sum = new int[rows + 1][cols + 1];
            for (int i = 1; i <= rows; i++) {
                int rowSum = 0;
                for (int j = 1; j <= cols; j++) {
                    rowSum += matrix[i - 1][j - 1];
                    sum[i][j] = rowSum + sum[i - 1][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return (sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1]);
        }
    }
}

package algorithms.medium;

public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length, cols = mat[0].length;
        int len = 1;
        int[][] sum = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            int rowSum = 0;
            for (int j = 1; j <= cols; j++) {
                rowSum += mat[i - 1][j - 1];
                sum[i][j] = rowSum + sum[i - 1][j];
                if (i >= len && j >= len && getCurrentSquareSum(sum, i, j, len) <= threshold) {
                    len++;
                }
            }

        }
        return len - 1;
    }

    private int getCurrentSquareSum(int[][] sum, int i, int j, int len) {
        return sum[i][j] - sum[i - len][j] - sum[i][j - len] + sum[i - len][j - len];
    }

}
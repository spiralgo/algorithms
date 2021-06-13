package algorithms.curated170.medium;

public class LongestLineOfConsecutiveOneInMatrixChecking {

    final int[] VERTICAL = new int[] { 0, 1 };
    final int[] HORIZONTAL = new int[] { 1, 0 };
    final int[] DIAGONAL = new int[] { 1, 1 };
    final int[] ANTIDIAGONAL = new int[] { 1, -1 };

    int n, m;

    public int longestLine(int[][] mat) {

        int max = 0;
        n = mat.length;
        m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    continue;
                }

                if (j == 0 || mat[i][j - 1] == 0) {
                    max = Math.max(max, explore(VERTICAL, i, j, mat));
                }

                if (i == 0 || mat[i - 1][j] == 0) {
                    max = Math.max(max, explore(HORIZONTAL, i, j, mat));
                }

                if (i == 0 || j == 0 || mat[i - 1][j - 1] == 0) {
                    max = Math.max(max, explore(DIAGONAL, i, j, mat));
                }

                if (i == 0 || j == m - 1 || mat[i - 1][j + 1] == 0) {
                    max = Math.max(max, explore(ANTIDIAGONAL, i, j, mat));
                }
            }
        }

        return max;
    }

    public int explore(int[] dir, int i, int j, int[][] mat) {
        
        int count = 0;

        while (isOnGridAndOne(i, j, mat)) {
            count++;
            i += dir[0];
            j += dir[1];
        }

        return count;
    }

    private boolean isOnGridAndOne(int i, int j, int[][] mat) {
        return i >= 0 && i < n && j >= 0 && j < m && mat[i][j] != 0;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] { { 1, 1, 1, 0, 0 },
                                    { 0, 1, 1, 0, 0 }, 
                                    { 0, 0, 1, 0, 1 }, 
                                    { 0, 0, 0, 1, 0 }, };
                                    
        var solution = new LongestLineOfConsecutiveOneInMatrixChecking();
        
        System.out.println(solution.longestLine(mat));

        mat = new int[][] { 
                { 1, 1, 0, 0, 1, 0, 0, 1, 1, 0 },
                { 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 0, 1, 1, 1, 1, 0 }, 
                { 0, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, 
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 }, 
                { 0, 1, 1, 1, 1, 1, 1, 0, 0, 1 }, 
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 }, 
                { 0, 1, 1, 0, 1, 0, 1, 1, 1, 1 } };

        System.out.println(solution.longestLine(mat));
        
    }
}
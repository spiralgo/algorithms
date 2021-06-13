package algorithms.curated170.medium;

public class LongestLineOfConsecutiveOneInMatrixDP {

    public int longestLine(int[][] mat) {

        int m = mat[0].length;
        int n = mat.length;
        
        int max = 0;
        
        int horizontal = 0;
        int[] vertical = new int[m];
        int[] antiDiagonal = new int[n + m];
        int[] diagonal = new int[n + m];

        for (int i = 0; i < n; i++) {
            horizontal = 0;    
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 1) {
                    horizontal = 0;
                    vertical[j] = 0;
                    antiDiagonal[j + i] = 0;
                    diagonal[j - i + n] = 0;
                    continue;
                }

                horizontal++;
                vertical[j]++;
                antiDiagonal[j + i]++;
                diagonal[j - i + n]++;
                max = Math.max(max, horizontal);
                max = Math.max(max, vertical[j]);
                max = Math.max(max, antiDiagonal[j + i]);
                max = Math.max(max, diagonal[j - i + n]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] { { 1, 1, 1, 0, 0 },
                                    { 0, 1, 1, 0, 0 }, 
                                    { 0, 0, 1, 0, 1 }, 
                                    { 0, 0, 0, 1, 0 }, };
                                    
        var solution = new LongestLineOfConsecutiveOneInMatrixDP();
        
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
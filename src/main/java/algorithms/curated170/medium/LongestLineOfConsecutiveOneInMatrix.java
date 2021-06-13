package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.BitSet;

public class LongestLineOfConsecutiveOneInMatrix {

    final int X_DIR = 0;
    final int Y_DIR = 1;
    final int BIT_FLAG = 2;
    final int[] vertical = new int[] { 0, 1, 0b10 };
    final int[] horizontal = new int[] { 1, 0, 0b100 };
    final int[] diagonal = new int[] { 1, 1, 0b1000 };
    final int[] antidiagonal = new int[] { 1, -1, 0b10000 };
    final int[][] DIRECTIONS = new int[][] { null, vertical, horizontal, diagonal, antidiagonal };

    int[][] mat;
    int n, m;
    int longest = 0;

    public int longestLine(int[][] mat) {
        this.mat = mat;
        n = mat.length;
        m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                exploreTile(i, j);
            }
        }
        return longest;
    }

    void exploreTile(int i, int j) {
        final int TILE_VAL = mat[i][j];
        if (TILE_VAL < 1) {
            return;
        }
        for (int flagIndex = 1; flagIndex <= 4; flagIndex++) {
            if (!hasFlag(TILE_VAL, flagIndex)) {
                goInDir(i, j, 1, DIRECTIONS[flagIndex]);
            }
        }
    }

    boolean hasFlag(final int TILE_VAL, final int FLAG_INDEX) {

        final int FLAG = DIRECTIONS[FLAG_INDEX][BIT_FLAG];
        final int VAL_ON_FLAG = FLAG & TILE_VAL;
        if ((VAL_ON_FLAG >> FLAG_INDEX) != 0) {
            return true;
        }
        return false;
    }

    void goInDir(int i, int j, int length, final int[] DIR) {

        if (j < 0 || j >= m || i >= n || mat[i][j] < 1) {
            return;
        }

        longest = Math.max(longest, length);
        mat[i][j] |= DIR[BIT_FLAG];
        goInDir(i + DIR[X_DIR], j + DIR[Y_DIR], length + 1, DIR);
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] { { 1, 1, 1, 0, 0 },
                                    { 0, 1, 1, 0, 0 }, 
                                    { 0, 0, 1, 0, 1 }, 
                                    { 0, 0, 0, 1, 0 }, };
                                    
        var solution = new LongestLineOfConsecutiveOneInMatrix();
        
        System.out.println(solution.longestLine(mat));

        mat = new int[][] { 
                { 1, 1, 0, 0, 1, 0, 0, 1, 1, 0 },
                { 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 0, 1, 1, 1, 1, 0 }, 
                { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, 
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 }, 
                { 0, 1, 1, 1, 1, 1, 1, 0, 0, 1 }, 
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 }, 
                { 1, 1, 1, 0, 1, 0, 1, 1, 1, 1 } };

        System.out.println(solution.longestLine(mat));
        
    }
}
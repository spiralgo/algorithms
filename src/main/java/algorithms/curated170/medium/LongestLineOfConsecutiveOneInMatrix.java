package algorithms.curated170.medium;

import java.util.Arrays;

public class LongestLineOfConsecutiveOneInMatrix {

    final int VERTICAL = 0b10;
    final int HORIZONTAL = 0b100;
    final int DIAGONAL = 0b1000;
    final int ANTID = 0b10000;

    int[][] mat;
    int n, m;
    int longest = 0;

    public int longestLine(int[][] mat) {
        this.mat = mat;
        n = mat.length;
        m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                control(i, j);
            }
        }
        return longest;
    }

    void control(int i, int j) {
        int curr = mat[i][j];
        if (!hasFlag(curr, VERTICAL)) {
            goVertical(i, j, 1);
        }
        if (!hasFlag(curr, HORIZONTAL)) {
            goHorizontal(i, j, 1);
        }
        if (!hasFlag(curr, DIAGONAL)) {
            goDiagonal(i, j, 1);
        }
        if (!hasFlag(curr, ANTID)) {
            goAntidiagonal(i, j, 1);
        }
    }

    boolean hasFlag(int curr, int flag) {
        if (curr < 1) {
            return true;
        }
        if (flag == VERTICAL) {
            int shift = flag & curr;
            if ((shift >> 1) > 0) {
                return true;
            }
            return false;
        } else if (flag == HORIZONTAL) {
            int shift = flag & curr;
            if ((shift >> 2) > 0) {
                return true;
            }
            return false;
        } else if (flag == DIAGONAL) {
            int shift = flag & curr;
            if ((shift >> 3) > 0) {
                return true;
            }
            return false;
        }
        else if (flag == ANTID) {
            int shift = flag & curr;
            if ((shift >> 4) > 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    void goDiagonal(int i, int j, int length) {
        if (j >= m || i >= n || mat[i][j] < 1) {
            return;
        }
        longest = Math.max(longest, length);
        mat[i][j] |= DIAGONAL;
        goDiagonal(i + 1, j + 1, length + 1);
    }

    void goAntidiagonal(int i, int j, int length) {
        if (j < 0 || i >= n || mat[i][j] < 1) {
            return;
        }
        longest = Math.max(longest, length);
        mat[i][j] |= ANTID;
        goAntidiagonal(i + 1, j - 1, length + 1);
    }

    void goVertical(int i, int j, int length) {
        if (j >= m || mat[i][j] < 1) {
            return;
        }

        longest = Math.max(longest, length);
        mat[i][j] |= VERTICAL;
        goVertical(i, j + 1, length + 1);
    }

    void goHorizontal(int i, int j, int length) {
        if (i >= n || mat[i][j] < 1) {
            return;
        }
        longest = Math.max(longest, length);
        mat[i][j] |= HORIZONTAL;
        goHorizontal(i + 1, j, length + 1);
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 }, };
        var solution = new LongestLineOfConsecutiveOneInMatrix();
        /*
         * int k = 0b11; System.out.println(solution.hasFlag(k, solution.vertical)); k =
         * 0b101; System.out.println(solution.hasFlag(k, solution.vertical)); k = 1;
         * System.out.println(solution.hasFlag(k, solution.vertical));
         */
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
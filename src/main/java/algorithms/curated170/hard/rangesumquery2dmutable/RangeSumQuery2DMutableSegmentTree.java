package algorithms.curated170.hard.rangesumquery2dmutable;

import java.util.Arrays;

public class RangeSumQuery2DMutableSegmentTree {

    class NumMatrix {
        int[][] tree;
        int m, n;

        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            tree = new int[m << 1][n << 1];
            buildTree(matrix);
        }

        private void buildTree(int[][] mat) {
            for (int i = m; i < (m << 1); i++) {
                for (int j = n; j < (n << 1); j++) {
                    tree[i][j] = mat[i - m][j - n];
                }
            }
            for (int i = m - 1; i > 0; i--) {
                for (int j = n; j < (n << 1); j++) {
                    tree[i][j] = tree[2 * i][j] + tree[2 * i + 1][j];
                }
            }

            for (int i = 1; i < (m << 1); i++) {
                for (int j = n - 1; j > 0; j--) {
                    tree[i][j] = tree[i][2 * j] + tree[i][2 * j + 1];
                }
            }
        }

        public void update(int row, int col, int val) {
            row += m;
            col += n;

            int i = row, j = col;
            for (tree[i][j] = val; j > 0; j >>= 1) {
                tree[i][j >> 1] = tree[i][j] + tree[i][j ^ 1];
            }

            for (i = row >> 1; i > 0; i >>= 1) {
                tree[i][col] = tree[i << 1 | 1][col] + tree[i << 1][col];
                for (j = col; j > 0; j >>= 1) {
                    tree[i][j >> 1] = tree[i][j] + tree[i][j ^ 1];
                }
            }
        }

        public int sumRegion(int row1, int c1, int row2, int c2) {
            int sum = 0;
            for (row1 += m, row2 += m; row1 <= row2; row1 >>= 1, row2 >>= 1) {
                if ((row1 & 1) == 1) {
                    sum += sumRange(row1, c1, c2);
                    row1++;
                }
                if ((row2 & 1) == 0) {
                    sum += sumRange(row2, c1, c2);
                    row2--;
                }
            }
            return sum;
        }

        private int sumRange(int r, int c1, int c2) {
            int sum = 0;
            for (c1 += n, c2 += n; c1 <= c2; c1 >>= 1, c2 >>= 1) {
                if ((c1 & 1) == 1)
                    sum += tree[r][c1++];
                if ((c2 & 1) == 0)
                    sum += tree[r][c2--];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        var solution = new RangeSumQuery2DMutableSegmentTree();

        int[][] matrix = new int[][] { { 4, 7, 3, -1 }, { 2, 1, 9, 5 }, { -7, 3, 4, 0 }, { 8, 2, 1, 6 } };
        var nm = solution.new NumMatrix(matrix);

        nm.update(2, 1, 7);
        System.out.println(nm.sumRegion(1, 1, 3, 2));
    }
}

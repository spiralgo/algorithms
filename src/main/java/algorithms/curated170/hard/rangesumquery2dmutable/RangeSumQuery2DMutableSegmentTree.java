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
            buildLeavesOfLeaves(mat);
            
            buildLeavesOfRoots();

            buildRoots();
        }

        private void buildRoots() {
            for (int i = 1; i < (m << 1); i++) {
                for (int j = n - 1; j > 0; j--) {
                    tree[i][j] = tree[i][2 * j] + tree[i][2 * j + 1];
                }
            }
        }

        private void buildLeavesOfRoots() {
            for (int i = m - 1; i > 0; i--) {
                for (int j = n; j < (n << 1); j++) {
                    tree[i][j] = tree[2 * i][j] + tree[2 * i + 1][j];
                }
            }
        }

        private void buildLeavesOfLeaves(int[][] mat) {
            for (int i = m; i < (m << 1); i++) {
                for (int j = n; j < (n << 1); j++) {
                    tree[i][j] = mat[i - m][j - n];
                }
            }
        }

        public void update(int row, int col, int val) {
            row += m;
            col += n;
            
            tree[row][col] = val;
            updateBase(row, col);

            updateRoots(row, col);
        }

        private void updateBase(int row, int col) {
            for (int i = row, j = col; j > 0; j >>= 1) {
                tree[i][j >> 1] = tree[i][j] + tree[i][j ^ 1];
            }
        }

        private void updateRoots(int row, int col) {
            for (int i = row >> 1; i > 0; i >>= 1) {
                tree[i][col] = tree[i << 1 | 1][col] + tree[i << 1][col];

                for (int j = col; j > 0; j >>= 1) {
                    tree[i][j >> 1] = tree[i][j] + tree[i][j ^ 1];
                }
            }
        }

        public int sumRegion(int r1, int c1, int r2, int c2) {
            int sum = 0;
            for (r1 += m, r2 += m; r1 <= r2; r1 >>= 1, r2 >>= 1) {
                if (isRightChild(r1)) {
                    sum += sumRange(r1, c1, c2);
                    r1++;
                }
                if (isLeftChild(r2)) {
                    sum += sumRange(r2, c1, c2);
                    r2--;
                }
            }
            return sum;
        }

        private boolean isLeftChild(int r2) {
            return (r2 & 1) == 0;
        }

        private boolean isRightChild(int r1) {
            return (r1 & 1) == 1;
        }

        private int sumRange(int r, int c1, int c2) {
            int sum = 0;
            for (c1 += n, c2 += n; c1 <= c2; c1 >>= 1, c2 >>= 1) {
                if (isRightChild(c1))
                    sum += tree[r][c1++];
                if (isLeftChild(c2))
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

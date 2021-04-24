package algorithms;

import java.util.Arrays;
import java.util.Random;

public class LinearAlgebra {
    public static int dotProduct(int[] A, int[] B) {
        int size = A.length;
        if (size != B.length) {
            return Integer.MIN_VALUE;
        }
        int dp = 0;
        for (int i = 0; i < size; i++) {
            dp += A[i] * B[i];
        }
        return dp;
    }

    public static int[] crossProduct(int[] A, int[] B) {
        // Defined for 3 dimensions
        if (A.length != 3 || B.length != 3) {
            return new int[] { 0, 0, 0 };
        }
        int[] cp = new int[3];
        cp[0] = A[1] * B[2] - B[1] * A[2];
        cp[1] = A[2] * B[0] - B[2] * A[0];
        cp[2] = A[0] * B[1] - B[0] * A[1];
        return cp;
    }

    public static int determinant(int[][] A) {
        int a = A.length;
        if (a != A[0].length || a < 2) {
            return Integer.MIN_VALUE;
        }
        if (a == 2) {
            return A[0][0] * A[1][1] - A[0][1] * A[1][0];
        }
        int det = 0;
        for (int i = 0; i < a; i++) {
            if (i % 2 == 0) {
                det += A[0][i] * determinant(minorMatrix(A, i));
            } else {
                det -= A[0][i] * determinant(minorMatrix(A, i));
            }
        }
        return det;
    }

    private static int[][] minorMatrix(int[][] A, int i) {
        int a = A.length;
        int[][] min = new int[a - 1][a - 1];
        int p = 0;
        for (int k = 1; k < a; k++) {
            for (int j = 0; j < a; j++) {
                if (j == i) {
                    continue;
                }
                min[k - 1][p] = A[k][j];
                p++;
            }
            p = 0;
        }
        return min;
    }

    public static int[][] matrixMultiplication(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, l = B[0].length;
        if (n != B.length) // They can't be multiplied
        {
            return new int[][] { { 0 } };
        }
        int[][] C = new int[m][l];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < l; k++) {
                        C[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }

        return C;
    }

    public static void main(String[] args) {
        int[][] A = new int[3][3];
        int[][] B = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = new Random().nextInt(10);
                B[i][j] = new Random().nextInt(10);
            }
        }
        System.out.println(Arrays.deepToString(A));
        System.out.println(determinant(A));
        System.out.println(Arrays.deepToString(B));
        System.out.println(Arrays.deepToString(matrixMultiplication(A, B)));
        //System.out.println(Arrays.deepToString(SparseMatrixMultiplicationWithHashMap.solution(A, B)));
        System.out.println(Arrays.deepToString(matrixMultiplication(B, A)));
        System.out.println(
                Arrays.deepToString(matrixMultiplication(matrixMultiplication(B, A), matrixMultiplication(A, B))));
        System.out.println(
                Arrays.deepToString(matrixMultiplication(matrixMultiplication(A, B), matrixMultiplication(B, A))));

    }
}
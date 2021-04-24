package algorithms.curated170.medium;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplicationWithHashMap {
    public static int[][] solution(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] C = new int[m][l];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        map = compress(B);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k : map.get(j).keySet()) {
                        C[i][k] += A[i][j] * map.get(j).get(k); // We add these numbers to the positions in the output
                                                                // accordingly.
                    }
                }
            }
        }
        return C;
    }

    private static HashMap<Integer, Map<Integer, Integer>> compress(int[][] mat) {
        HashMap<Integer, Map<Integer, Integer>> compressedMatrix = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {

                    compressedMatrix.get(i).put(j, mat[i][j]);
                }
            }
        }
        return compressedMatrix;
    }

    public static void main(String[] args) {

    }
}

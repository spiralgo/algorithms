package algorithms.curated170.medium.sparsematrixmultiplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class SparseMatrixMultiplicationWithHashMap {

    public static int[][] multiply(int[][] A, int[][] B) {
        int mA = A.length;
        int nB = B[0].length;
        int[][] C = new int[mA][nB];
        Map<Integer, Map<Integer, Integer>> mapB = compress(B);
        Map<Integer, Map<Integer, Integer>> mapA = compress(A);
        for (int i : mapA.keySet()) {
            for (int j : mapA.get(i).keySet()) {
                for (int k : mapB.get(j).keySet()) {
                    C[i][k] += mapA.get(i).get(j) * mapB.get(j).get(k);
                }
            }
        }
        return C;
    }

    private static HashMap<Integer, Map<Integer, Integer>> compress(int[][] mat) {
        HashMap<Integer, Map<Integer, Integer>> compressedMatrix = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            compressedMatrix.put(i, new HashMap<>());
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {

                    compressedMatrix.get(i).put(j, mat[i][j]);
                }
            }
        }
        return compressedMatrix;
    }

    public static void main(String[] args) {
        int[][] A = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] B = new int[][] { { 9, 8, 7 }, { 12, 11, 10 }, { 15, 14, 13 } };
        System.out.println(Arrays.deepToString(multiply(A, B)));

    }
}

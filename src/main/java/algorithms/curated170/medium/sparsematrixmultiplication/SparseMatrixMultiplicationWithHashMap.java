package algorithms.curated170.medium.sparsematrixmultiplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class SparseMatrixMultiplicationWithHashMap {
    public static int[][] solution(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] C = new int[m][l];
        Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();
        mapB = compress(B);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k : mapB.get(j).keySet()) {
                        C[i][k] += A[i][j] * mapB.get(j).get(k); // We add these numbers to the positions in the output
                                                                // accordingly.
                    }
                }
            }
        }
        return C;
    }
    public static int[][] solutionModular(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] C = new int[m][l];
        Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();
        mapB = compress(B);
        Map<Integer, Map<Integer, Integer>> mapA = new HashMap<>();
        mapA = compress(A);
        for(int i : mapA.keySet())
        {
            for(int j : mapA.get(i).keySet())
            {
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
        int[][] A = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] B = new int[][]{{9,8,7},{12,11,10},{15,14,13}};
        System.out.println(Arrays.deepToString(solution(A, B)));
        System.out.println(Arrays.deepToString(solutionModular(A, B)));

    }
}

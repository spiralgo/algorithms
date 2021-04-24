package algorithms.curated170.medium;
import java.util.Arrays;

import algorithms.LinearAlgebra;

public class SparseMatrixMultiplication{
    public static int[][] solution(int[][] A, int[][] B) {
        return LinearAlgebra.matrixMultiplication(A, B);
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] B = new int[][]{{9,8,7},{12,11,10},{15,14,13}};
        System.out.println(Arrays.deepToString(solution(A, B)));
    }
}

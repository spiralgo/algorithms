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

        for(int i=0; i< n; i++){
            map.put(i, new HashMap<Integer, Integer>());
            for(int j = 0; j<l; j++){
                if(B[i][j] != 0){
                    map.get(i).put(j, B[i][j]); //We store all numbers that are not zero.
                }
            }
        }
        for(int i=0; i< m; i++){
            for(int j =0; j<n; j++){
                if(A[i][j] != 0){
                    for(int k : map.get(j).keySet()){
                        C[i][k] += A[i][j]  * map.get(j).get(k); //We add these numbers to the positions in the output accordingly.
                    }
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {

    }
}

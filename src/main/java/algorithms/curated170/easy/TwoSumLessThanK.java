package algorithms.curated170.easy;

import java.util.Arrays;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A); // Time cost O(nlogn).
        int max = -1, i = 0, j = A.length - 1; 
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < K) { // find one candidate.
                max = Math.max(max, sum);
                ++i; // increase the smaller element.
            }else { // >= sum.
                --j; // decrease the bigger element.
            }
        }
        return max;
    }
}

package algorithms.curated170.medium;

import java.rmi.ConnectIOException;

public class MaxConsecutiveOnes2 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        int best = 0;
        byte state = 0;

        for (int n : nums) {
            switch (state) {
                case 0:
                    if (n == 1) {
                        left++;
                        state = 1;
                        break;
                    }
                    break;
                case 1:
                    if (n == 1) {
                        left++;
                        break;
                    }
                    state = 2;
                    break;
                case 2:
                    if (n == 1) {
                        right++;
                        break;
                    }
                    best = Math.max(best, left + right + 1);
                    left = right;
                    right = 0;

                    state = 3;
                    break;
                case 3:
                    if (n == 1) {
                        right++;
                        state = 2;
                        break;
                    }
                    state = 0;
                    break;
            }
        }
        best = Math.max(best, left + right + 1);
        return best;
    }

    public static void main(String[] args) {
        var solution = new MaxConsecutiveOnes2();
        int[] nums = new int[] { 1, 0, 1, 1, 0, 1, 1 };

        System.out.println(solution.findMaxConsecutiveOnes(nums));

    }
}
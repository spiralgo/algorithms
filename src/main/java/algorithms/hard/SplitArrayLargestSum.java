package algorithms.hard;

import java.util.Arrays;
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];

        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + nums[i];
        }

        for (int splits = 2; splits <= m; splits++) {
            System.out.println(Arrays.toString(dp));
            int maxElements = nums.length + 1 - splits;

            for (int i = 0; i < maxElements; i++) {
                dp[i] = Integer.MAX_VALUE;
                int preSum = 0;

                for (int p = i; p < maxElements; p++) {
                    preSum += nums[p];
                    if (preSum > dp[i]) {
                        break; 
                    }

                    int splitMaxSum = Math.max(preSum, dp[p + 1]);
                    if (splitMaxSum < dp[i])
                        dp[i] = splitMaxSum;
                }

                if (splits == m){
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8, 12, 3, 4, 9, 5, 7, 4};
        var solution = new SplitArrayLargestSum();
        solution.splitArray(nums, 3);
    }
}

package algorithms.hard;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int sum = 0, max = nums[0];
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }
        int minSum = max, maxSum = sum;
        while (minSum < maxSum) {
            final int MID = minSum + (maxSum - minSum) / 2;
            if (canSplitToLessSum(nums, MID, m)) {
                maxSum = MID;
            } else {
                minSum = MID + 1;
            }
        }
        
        return minSum;
    }

    private boolean canSplitToLessSum(int[] nums, final int TARGET, final int TOTAL_SPLIT) {
        int splitCount = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= TARGET) {
                sum += nums[i];
                continue;
            }
            splitCount++;
            sum = nums[i];
            if (splitCount > TOTAL_SPLIT) {
                return false;
            }

        }

        return splitCount + 1 <= TOTAL_SPLIT;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8, 12, 3, 4, 9, 5, 7, 4 };
        var solution = new SplitArrayLargestSum();
        solution.splitArray(nums, 3);
    }
}

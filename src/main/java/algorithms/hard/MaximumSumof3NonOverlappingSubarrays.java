package algorithms.hard;

public class MaximumSumof3NonOverlappingSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        final int n = nums.length;
        int maxSum = 0;

        int[] sum = new int[n + 1], leftBestIdx = new int[n], rightBestIdx = new int[n];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = k, maxSum = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > maxSum) {
                leftBestIdx[i] = i + 1 - k;
                maxSum = sum[i + 1] - sum[i + 1 - k];
            } else {
                leftBestIdx[i] = leftBestIdx[i - 1];
            }
        }

        rightBestIdx[n - k] = n - k;
        for (int i = n - k - 1, maxsum = sum[n] - sum[n - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= maxsum) {
                rightBestIdx[i] = i;
                maxsum = sum[i + k] - sum[i];
            } else {
                rightBestIdx[i] = rightBestIdx[i + 1];
            }
        }

        int[] subarraysSums = new int[3];
        int maxSum = 0;
        for (int second = k; second <= n - 2 * k; second++) {
            int first = leftBestIdx[second - 1], third = rightBestIdx[second + k];
            int total = getBestSubarraysSums(k, sum, first, second, third);
            if (total > maxSum) {
                maxSum = total;
                subarraysSums[0] = first;
                subarraysSums[1] = second;
                subarraysSums[2] = third;
            }
        }
        return subarraysSums;
    }

    private int getBestSubarraysSums(int k, int[] sum, int first, int second, int third) {
        int total = (sum[second + k] - sum[second]) + (sum[first + k] - sum[first]) + (sum[third + k] - sum[third]);
        return total;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8, 12, 3, 4, 9, 5, 7, 4 };
        var solution = new MaximumSumof3NonOverlappingSubarrays();
        solution.maxSumOfThreeSubarrays(nums, 3);
    }
}

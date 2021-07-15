package algorithms.hard;

public class MaximumSumof3NonOverlappingSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        final int N = nums.length;

        int[] sum = new int[N + 1], leftBestIdx = new int[N], rightBestIdx = new int[N];

        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int maxLeftPresum = sum[k] - sum[0];
        for (int i = k; i < N; i++) {
            int currLeftSum = sum[i + 1] - sum[i + 1 - k];
            if (currLeftSum > maxLeftPresum) {
                leftBestIdx[i] = i + 1 - k;
                maxLeftPresum = currLeftSum;
            } else {
                leftBestIdx[i] = leftBestIdx[i - 1];
            }
        }

        rightBestIdx[N - k] = N - k;
        int maxRightPresum = sum[N] - sum[N - k];
        for (int i = N - k - 1; i >= 0; i--) {
            int currRightSum = sum[i + k] - sum[i];
            if (currRightSum >= maxRightPresum) {
                rightBestIdx[i] = i;
                maxRightPresum = currRightSum;
            } else {
                rightBestIdx[i] = rightBestIdx[i + 1];
            }
        }

        int[] subarraysSums = new int[3];
        int maxSum = 0;
        for (int second = k; second <= N - 2 * k; second++) {
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

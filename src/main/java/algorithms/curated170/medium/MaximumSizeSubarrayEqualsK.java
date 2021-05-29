package algorithms.curated170.medium;

import java.util.HashMap;    


public class MaximumSizeSubarrayEqualsK {

      public int maxSubArrayLen(int[] nums, int k) {

            HashMap<Integer, Integer> sumIndices = new HashMap<>(){{
                  put(0, -1);
            }};
            int currSum = 0;
            int maxRange = 0;
            for (int i = 0; i < nums.length; i++) {
                  currSum += nums[i];

                  maxRange = Math.max(maxRange, i - sumIndices.getOrDefault(currSum - k, Integer.MAX_VALUE));

                  sumIndices.putIfAbsent(currSum, i);
            }
            return maxRange;
      }

      public static void main(String[] args) {
            var solution = new MaximumSizeSubarrayEqualsK();

            int[] nums = new int[] { 1, -1, 5, -2, 3, -2 };
            System.out.println(solution.maxSubArrayLen(nums, 3)); // prints 5

            nums = new int[] { 1, -1, 5, -2, 3 };
            System.out.println(solution.maxSubArrayLen(nums, 3)); // prints 4

            nums = new int[] { 3 };
            System.out.println(solution.maxSubArrayLen(nums, 3)); // prints 1

            nums = new int[] { -2, -1, 2, 1, -2 };
            System.out.println(solution.maxSubArrayLen(nums, 1)); // prints 3
      }
}
package algorithms.curated170.medium;

import java.util.HashMap;

public class MaximumSizeSubarrayEqualsK {
      public int maxSubArrayLen(int[] nums, int k) {
            HashMap<Integer, Integer> indexStart = new HashMap<>();
            int tempSum = 0;
            int maxRange = 0;
            for (int i = 0; i < nums.length; i++) {
                  int num = nums[i];
                  tempSum += num;
                  maxRange = Math.max(maxRange, i - indexStart.getOrDefault(tempSum - 3, Integer.MAX_VALUE));
                  System.out.println(indexStart);
                  if(!indexStart.containsKey(tempSum)) indexStart.put(tempSum, i);
            }
            return maxRange;
      }

      public static void main(String[] args) {
            var solution = new MaximumSizeSubarrayEqualsK();
            int[] nums = new int[] { 1, -1, 5, -2, 3};
            System.out.println(solution.maxSubArrayLen(nums, 3));
      }
}
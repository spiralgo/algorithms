package algorithms.medium;

import algorithms.Quickselect;

public class MinimumMovesToEqualArrayElements2Quickselect {
    Quickselect qs = new Quickselect();

    public int minMoves2(int[] nums) {
        int ans = 0, median = qs.selectIterative(nums, 0, nums.length - 1, nums.length / 2 + 1);
        for (int i = 0; i < nums.length; i++)
            ans += Math.abs(median - nums[i]);
        return ans;
    }
    
}

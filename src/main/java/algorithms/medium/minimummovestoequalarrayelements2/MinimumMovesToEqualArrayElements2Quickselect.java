package algorithms.medium.minimummovestoequalarrayelements2;

import algorithms.Quickselect;

public class MinimumMovesToEqualArrayElements2Quickselect {
    Quickselect qs = new Quickselect();

    public int minMoves2(int[] nums) {
        int moves = 0;
        int median = qs.selectIterative(nums, 0, nums.length - 1, nums.length / 2 + 1);
        for (int i = 0; i < nums.length; i++) {
            moves += Math.abs(median - nums[i]);
        }
        
        return moves;
    }

}

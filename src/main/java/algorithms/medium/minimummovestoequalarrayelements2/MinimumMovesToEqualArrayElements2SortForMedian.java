package algorithms.medium.minimummovestoequalarrayelements2;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements2SortForMedian {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;
        for (int i = 0; i < nums.length; i++) {
            moves += Math.abs(median - nums[i]);
        }
        
        return moves;
    }

}

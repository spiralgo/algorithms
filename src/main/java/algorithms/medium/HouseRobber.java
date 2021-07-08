package algorithms.medium;

public class HouseRobber {

    public int rob(int[] nums) {
        int stealNow = 0, prevSteal = 0, stolen = 0;
        for (int i = 0; i < nums.length; i++) {
            prevSteal = stealNow;
            stealNow = Math.max(prevSteal, stolen + nums[i]);
            stolen = prevSteal;
        }
        return stealNow;
    }
}

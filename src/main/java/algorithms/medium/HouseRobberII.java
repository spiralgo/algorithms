package algorithms.medium;

public class HouseRobberII {

    public int rob(int[] nums) {
        
        int stealNowA = 0, prevSteal = 0, stolen = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            prevSteal = stealNowA;
            stealNowA = Math.max(prevSteal, stolen + nums[i]);
            stolen = prevSteal;
        }

        prevSteal = 0;
        stolen = 0;
        int stealNowB = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            prevSteal = stealNowB;
            stealNowB = Math.max(prevSteal, stolen + nums[i]);
            stolen = prevSteal;
        }

        return Math.max(stealNowA, stealNowB);
    }
}

package algorithms.medium;

public class HouseRobberII {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int nowStolenA = 0, prevStolen = 0, stolen = 0;
        for (int i = 0; i < len - 1; i++) {
            prevStolen = nowStolenA;
            nowStolenA = Math.max(prevStolen, stolen + nums[i]);
            stolen = prevStolen;
        }

        prevStolen = 0;
        stolen = 0;
        int nowStolenB = 0;
        for (int i = 1; i < len; i++) {
            prevStolen = nowStolenB;
            nowStolenB = Math.max(prevStolen, stolen + nums[i]);
            stolen = prevStolen;
        }

        return Math.max(nowStolenA, nowStolenB);
    }
}

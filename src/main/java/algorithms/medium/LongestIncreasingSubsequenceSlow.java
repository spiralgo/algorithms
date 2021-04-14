package algorithms.medium;
// Refer to: https://github.com/altayhunoglu/algorithms/issues/101
public class LongestIncreasingSubsequenceSlow {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] currentElementPower = new int[nums.length];
        currentElementPower[0] = 1;
        int theMostPowerful = 1;
        for (int i = 1; i < currentElementPower.length; i++) {
            int previousMostPowerful = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    previousMostPowerful = Math.max(previousMostPowerful, currentElementPower[j]);
                }
            }
            currentElementPower[i] = previousMostPowerful + 1;
            theMostPowerful = Math.max(theMostPowerful, currentElementPower[i]);
        }
        return theMostPowerful;
    }
}

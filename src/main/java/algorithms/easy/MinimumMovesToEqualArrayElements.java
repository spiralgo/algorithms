package algorithms.easy;

public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int n : nums) {
            min = Math.min(min, n);
            sum += n;
        }
        return sum - nums.length * min;
    }

}
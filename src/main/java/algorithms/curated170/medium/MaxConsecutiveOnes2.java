package algorithms.curated170.medium;

public class MaxConsecutiveOnes2 {

    public int findMaxConsecutiveOnes(int[] nums) {
        
        int best = 0;
        int curr = 0, afterZeroCurr = 0;
        for (int n : nums) {
            if(n == 1)
            {
                curr++;
                afterZeroCurr++;
            }
            else
            {
                afterZeroCurr = curr+1;
                curr = 0;
            }

            best = Math.max(best, afterZeroCurr);
        }

        return best;
    }

    public static void main(String[] args) {
        var solution = new MaxConsecutiveOnes2();
        int[] nums = new int[] { 1, 0, 1, 1, 0, 1, 1 };

        System.out.println(solution.findMaxConsecutiveOnes(nums));

    }
}
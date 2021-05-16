package algorithms.curated170.medium;

public class MissingElementNaive {

    public int missingElement(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff < 2) {
                continue;
            } else if (diff <= k) {
                k -= (diff - 1);
            } else {
                return nums[i] + k;
            }
        }
        return nums[nums.length-1] + k;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 7, 9, 10 };
        var solution = new MissingElementNaive();
        System.out.println(solution.missingElement(nums, 3)); // prints 8
        System.out.println(solution.missingElement(nums, 9)); // prints 16

        nums = new int[] { 1, 2, 4 };
        System.out.println(solution.missingElement(nums, 3)); // prints 6
    }
}

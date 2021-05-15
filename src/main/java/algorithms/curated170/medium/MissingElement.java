package algorithms.curated170.medium;

public class MissingElement {

    public int missingElement(int[] nums, int k) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (countMissing(nums, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return nums[l - 1] + (k - countMissing(nums, l - 1));
    }

    private int countMissing(int[] nums, int i) {
        return nums[i] - nums[0] - i;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 7, 9, 10 };
        var solution = new MissingElement();
        System.out.println(solution.missingElement(nums, 3)); // prints 8 
       
        System.out.println(solution.missingElement(nums, 9)); // prints 16

        nums = new int[] { 1, 2, 4 };
        System.out.println(solution.missingElement(nums, 3)); // prints 6 
    }
}

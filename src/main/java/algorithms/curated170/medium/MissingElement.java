package algorithms.curated170.medium;

public class MissingElement {

       public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int m = (right + left)/ 2;
            if (countMissing(nums, m) >= k) {
                right = m;
               
            } else {
                left = m + 1;
            }
        }

        return nums[left - 1] + (k - countMissing(nums, left - 1));
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

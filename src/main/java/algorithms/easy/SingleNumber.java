package algorithms.easy;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int x1 = 0;
        for (int n : nums) {
            x1 ^= n;
        }
        return x1;
    }

    public static void main(String[] args) {
        var solution = new SingleNumber();

        int[] nums = new int[] { 2, 2, 3, 5, 7, 3, 9, 5, 7 };
        int[] nums2 = new int[] { 4, 3, 6, 0, 6, 4, 3 };

        System.out.println(solution.singleNumber(nums)); // prints 9
        System.out.println(solution.singleNumber(nums2)); // prints 0
    }
}
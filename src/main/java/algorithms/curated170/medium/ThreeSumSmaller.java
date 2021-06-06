package algorithms.curated170.medium;

import java.util.Arrays;

public class ThreeSumSmaller {

    int[] nums;

    public int threeSumSmaller(int[] nums, int target) {

        this.nums = nums;
        int count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            count += findTwoSumsSmaller(i + 1, target - nums[i]);
        }
        return count;
    }

    public int findTwoSumsSmaller(int start, int target) {

        int p1 = start, p2 = nums.length - 1;
        int count = 0;
        while (p1 < p2) {
            if (nums[p1] + nums[p2] >= target) {
                p2--;
            } else {
                count += p2 - p1;
                p1++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        var solution = new ThreeSumSmaller();

        int[] nums = new int[] { 0, 1, 3, 4, 8 };
        System.out.println(solution.threeSumSmaller(nums, 8));
    }
}
package algorithms.curated170.medium.threesumsmaller;

import java.util.Arrays;

public class ThreeSumSmallerRecursion {

    int[] nums;
    int target;
    int rightBoundary;

    public int threeSumSmaller(int[] nums, int target) {

        this.nums = nums;
        this.target = target;
        rightBoundary = nums.length - 1;
        Arrays.sort(nums);

        return reduceTwoSumsSmaller(0);
    }

    public int reduceTwoSumsSmaller(int start) {
        int currTarget = target - nums[start];
        int p1 = start + 1, p2 = rightBoundary;
        int count = 0;
        boolean foundBounds = false;
        while (p1 < p2) {
            if (nums[p1] + nums[p2] >= currTarget) {
                if (!foundBounds) {
                    rightBoundary--;
                }
                p2--;
            } else {
                foundBounds = true;
                count += p2 - p1;
                p1++;
            }
        }
        return count == 0 ? 0 : count + reduceTwoSumsSmaller(start + 1);
    }

    public static void main(String[] args) {

        var solution = new ThreeSumSmallerRecursion();

        int[] nums = new int[] { 0, 1, 3, 4, 8, 9, 11, 12 };
        System.out.println(solution.threeSumSmaller(nums, 8));
    }
}
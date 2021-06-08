package algorithms.curated170.medium.threesumsmaller;

import java.util.Arrays;

public class ThreeSumSmallerIterative {

    int[] nums;
    int rightBoundary;

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        
        this.nums = nums;
        int count = 0;
        rightBoundary = nums.length - 1;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int countAtIdx = findTwoSumsSmaller(i + 1, target - nums[i]);
            if (countAtIdx == 0) {
                break;
            }
            count += countAtIdx;
        }
        return count;
    }

    public int findTwoSumsSmaller(int start, int target) {

        int p1 = start, p2 = rightBoundary;
        int count = 0;
        boolean foundBounds = false;
        while (p1 < p2) {
            if (nums[p1] + nums[p2] >= target) {
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
        return count;
    }

    public static void main(String[] args) {

        var solution = new ThreeSumSmallerIterative();

        int[] nums = new int[] { 0, 1, 3, 4, 8, 9, 11, 12 };
        System.out.println(solution.threeSumSmaller(nums, 8));
    }
}
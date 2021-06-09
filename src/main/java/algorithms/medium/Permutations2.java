package algorithms.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        backtrack(0, nums, output);
        return output;

    }
    
    public void backtrack(int choiceIndex, int[] nums, List<List<Integer>> output) {
        if (choiceIndex == nums.length) {
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            for (int num : nums) {
                permutation.add(num);
            }
            output.add(permutation);
        }

        boolean[] visited = new boolean[21];
        for (int i = choiceIndex; i < nums.length; i++) {
            if (visited[nums[i] + 10]) {
                continue;
            }
            visited[nums[i] + 10] = true;
            swap(choiceIndex, i, nums);
            backtrack(choiceIndex + 1, nums, output);
            swap(i, choiceIndex, nums);

        }

    }

    public void swap(int choiceIndex, int i, int[] nums) {
        int temp = nums[choiceIndex];
        nums[choiceIndex] = nums[i];
        nums[i] = temp;
    }
}

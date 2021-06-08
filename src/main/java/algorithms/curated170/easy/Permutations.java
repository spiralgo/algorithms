package algorithms.curated170.easy;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
        public List<List<Integer>> permute(int[] nums) {
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

            for (int i = choiceIndex; i < nums.length; i++) {
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

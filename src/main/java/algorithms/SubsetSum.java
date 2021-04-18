package algorithms;

import java.util.*;

public class SubsetSum {
  // Return true if there is a subset of
  // set[] with sun equal to given sum

  static boolean solutionNaive(int[] nums, int n, int target) {
    //Time complexity: O(2^n)
    //Spatil complexity: O(1)

    //The sums spread out into a tree, which brings exponential number of operations

    //Base cases:
    if (target == 0)
    {
      /*If the number eventually reduce the target down to 0,
      this means that they can add up the target.*/
      return true;
    }
    if (n == 0)
    {
      /*If the method ends up going down in the array,
      it returns false.*/
      return false;
    }

    if (nums[n - 1] > target)
    {
      /*If the number is greater than the target, it should be ignored,
      as nothing would add up to the target with it.*/
      return solutionNaive(nums, n - 1, target);
    }
    /*Otherwise, the solution will either be obtained by ignoring the number and 
    checking the sum in the rest of the array or it will be obtained by subtracting
    the number from the target and considering the rest of the array.*/
    return solutionNaive(nums, n - 1, target) || solutionNaive(nums, n - 1, target - nums[n - 1]);
  }

  static boolean solutionDP0(int[] nums, int target) {
    //Time complexity: O(target*nums.length)
    //Spatial complexity: O(target)

    if (target == 0) {
      return true;
    }
    boolean[] sums = new boolean[target + 1];
    sums[0] = true;
    for (int i : nums) {
      List<Integer> sumsToAdd = new ArrayList<>();
      for (int s = 0; s < target; s++) {
        int sum = s + i;
        if (sums[s]) {
          if (sum == target) {
            return true;
          } else if (sum < target) {
            sumsToAdd.add(sum);
          }
        }
      }
      sumsToAdd.add(i);
      for (int s_ : sumsToAdd) {
        sums[s_] = true;
      }
    }
    return false;
  }

  static boolean solutionDP1(int[] nums, int target) {
    //Time complexity: O(target*nums.length)
    //On avarage, this one does less computations in comparison to solutionDP0.
    //It's relative speed is, however, depends on the speed comparison between HashSet<Integer> and boolean[].
    
    //Spatial complexity: O(target)
    //Likewise, the actual improvement or worsening of this dependent on the data structure of Integer and boolean.
    //In Java, int takes up 32 bits, whereas boolean takes up 1 bit.
    /*Hence, in the last operations, as the actual size of the HashSet does not really differ from the boolean[] of the size target,
    it can be concluded the memory of this method is actually 32 times more than that of solutionDP0.*/

    if (target == 0) {
      return true;
    }
    HashSet<Integer> set = new HashSet<>();
    set.add(0);
    for (int i : nums) {
      HashSet<Integer> setToAdd = new HashSet<>();
      for (int t : set) {
        int sum = i + t;
        if (sum == target) {
          return true;
        } else if (sum < target) {
          setToAdd.add(sum);
        }
      }
      setToAdd.add(i);
      set.addAll(setToAdd);
    }
    return false;
  }

  static List<Integer> solutionAddends(int[] nums, int target) {
    //This method is pretty similar to solutionDP1.
    //This additionally keeps track of which numbers add up to the individual sums.
    /*Differently, from the test results, it could be said that this method
    has a spatial complexity of O(target*nums.length)*/
    if (target == 0) {
      return List.of();
    }
    HashMap<Integer, List<Integer>> addendsMap = new HashMap<>();
    addendsMap.put(0, new LinkedList<Integer>());
    for (int i : nums) {
      HashMap<Integer, List<Integer>> addendsToAdd = new HashMap<>();
      for (Map.Entry<Integer, List<Integer>> set : addendsMap.entrySet()) {
        int sum = set.getKey() + i;
        if (sum == target) {
          set.getValue().add(i);
          return set.getValue();
        } else if (sum < target) {
          List<Integer> newAddends = new LinkedList<>();
          for (int a : set.getValue()) {
            newAddends.add(a);
          }
          newAddends.add(i);
          addendsToAdd.put(sum, newAddends);
        }
      }
      addendsMap.putAll(addendsToAdd);
    }
    return List.of(Integer.MIN_VALUE); //This means that it returns false
  }
  public static void main(String[] args) {
    int numsSize = 214;
    int[] nums = new int[numsSize];
    for (int i = 0; i < numsSize; i++) {
      nums[i] = new Random().nextInt(100);
    }
    int target = new Random().nextInt(1000) + 10000;
    System.out.println("Input: " + Arrays.toString(nums));
    System.out.println("Target: " + target);
    System.out.println(solutionDP1(nums, target));
    System.out.println(solutionDP0(nums, target));
    //At this input range, it is too inefficient to run. System.out.println(solutionNaive(nums, nums.length, target));
    System.out.println(solutionAddends(nums, target));
  }
}

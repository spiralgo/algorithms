package algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SingleNumber2 {

    public int singleNumber(int[] nums) {

        int x1 = 0, x2 = 0;

        for (int num : nums) {

            x1 = (x1 ^ num) & ~x2;
            x2 = (x2 ^ num) & ~x1;
        }
        return x1;
    }

    public int singleNumber4(int[] nums) {

        int x1 = 0, x2 = 0, x3 = 0;

        for (int num : nums) {

            x1 = (x1 ^ num) & ~x2 & ~x3;
            x2 = (x2 ^ num) & ~x1 & ~x3;
            x3 = (x3 ^ num) & ~x1 & ~x2;
        }
        return x1;
    }

    public int singleNumber5(int[] nums) {

        int x1 = 0, x2 = 0, x3 = 0, x4 = 0;

        for (int num : nums) {

            x1 = (x1 ^ num) & ~x2 & ~x3 & ~x4;
            x2 = (x2 ^ num) & ~x1 & ~x3 & ~x4;
            x3 = (x3 ^ num) & ~x1 & ~x2 & ~x4;
            x4 = (x4 ^ num) & ~x1 & ~x2 & ~x3;
        }
        return x1;
    }

    public int singleNumber6(int[] nums) {

        int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0;

        for (int num : nums) {

            x1 = (x1 ^ num) & ~x2 & ~x3 & ~x4 & ~x5;
            x2 = (x2 ^ num) & ~x1 & ~x3 & ~x4 & ~x5;
            x3 = (x3 ^ num) & ~x1 & ~x2 & ~x4 & ~x5;
            x4 = (x4 ^ num) & ~x1 & ~x2 & ~x3 & ~x5;
            x5 = (x5 ^ num) & ~x1 & ~x2 & ~x3 & ~x4;
        }
        return x1;
    }

    public int singleNumberGeneral(int[] nums, int k) {
        
        int[] sets = new int[k-1];

        for (int num : nums) {

            for (int i = 0; i < k-1; i++) {
                int x = sets[i] ^ num;
                for (int j = 0; j < k-1; j++) {
                    if (j != i) {
                        x &= ~sets[j];
                    }
                }
                sets[i] = x;
            }
        }
        return sets[0];
    }

    
    public static void main(String[] args) {

        var solution = new SingleNumber2();

        int[] nums_0 = new int[] { 2, 2, 5, 7, 7, 5, 9, 2, 5, 7 };
        int[] nums_1 = new int[] { 3, 3, 6, 0, 6, 6, 3 };

        System.out.println(solution.singleNumber(nums_0)); // prints 9
        System.out.println(solution.singleNumber(nums_1)); // prints 0
        System.out.println(solution.singleNumberGeneral(nums_0, 3)); // prints 9
        System.out.println(solution.singleNumberGeneral(nums_1, 3)); // prints 0

        int[] nums4 = { 4, 2, 4, 4, 18, 2, 2, 4, 2 };
        System.out.println(solution.singleNumber4(nums4)); // prints 8

        int[] nums5 = { 4, 2, 4, 4, 4, 2, 2, 4, 2, 18, 2 };
        System.out.println(solution.singleNumber5(nums5)); // prints 18

        int[] nums6 = { 2, 4, 2, 4, 4, 4, 2, 2, 4, 2, 180, 2, 4 };
        System.out.println(solution.singleNumber6(nums6)); // prints 180
        System.out.println(solution.singleNumberGeneral(nums6, 6)); // prints 180

        int[] singleNumber8 = singleNumberN(8, 5);
        System.out.println(Arrays.toString(singleNumber8));
        System.out.println(solution.singleNumberGeneral(singleNumber8,8));

        int[] singleNumber9 = singleNumberN(9, 9);
        System.out.println(Arrays.toString(singleNumber9));
        System.out.println(solution.singleNumberGeneral(singleNumber9,9));

        int[] singleNumber27 = singleNumberN(27, 9);
        System.out.println(Arrays.toString(singleNumber27));
        System.out.println(solution.singleNumberGeneral(singleNumber27,27)); 

        int[] singleNumber81 = singleNumberN(81, 81);
        System.out.println(Arrays.toString(singleNumber81));
        System.out.println(solution.singleNumberGeneral(singleNumber81,81));
    }

    static int[] singleNumberN(int N, int diffNums)
    {
        List<Integer> nums = new ArrayList<>();
        Set<Integer> diffSet = new HashSet<>();
        int lower = 0;
        for(int i = 0; i<diffNums; i++)
        {
            diffSet.add(new Random().nextInt(3)+lower);
            lower += 3;
        }
        Iterator<Integer> it = diffSet.iterator();
        int uniqueIndex = new Random().nextInt(diffNums);
        for(int i = 0; i<diffNums; i++)
        {
            if(i==uniqueIndex)
            {
                int unique = it.next();
                nums.add(unique);
                System.out.println("Unique number: " + unique);
                continue;
            }
            int k = it.next();
            for(int j = 0; j<N; j++)
            {
                nums.add(k);
            }
        }
        Collections.shuffle(nums);
        return nums.stream().mapToInt(Integer::intValue).toArray();
    }
}
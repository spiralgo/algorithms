package algorithms.curated170.medium.findpermutation;

import java.util.Arrays;
import java.util.Random;


public class FindPermutation {
    public static int[] findPermutation(String s) {
        int size = s.length();
        int[] permutation = new int[size + 1];

        for (int i = 0; i <= size; ++i) {
            permutation[i] = i + 1;
        }

        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == 'D') {
                int left = i;
                while (i < size && s.charAt(i) == 'D') {
                    i++;
                }
                reverse(permutation, left, i);
            }
        }
        return permutation;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start++] ^= nums[end--];
            /* int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp; */ 
        }
    }

    public static void main(String[] args) {
        int testSize = 20;
        char[] code_ = new char[testSize];
        for (int i = 0; i < testSize; i++) {
            int rand = new Random().nextInt(100);
            if (rand < 50) {
                code_[i] = 'I';
            } else {
                code_[i] = 'D';
            }
        }
        String code = new String(code_);
        System.out.println(code);
        System.out.println(Arrays.toString(findPermutation(code)));

    }
}

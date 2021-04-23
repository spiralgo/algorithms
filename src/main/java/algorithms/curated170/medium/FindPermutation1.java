package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.Random;

public class FindPermutation1 {
    public static int[] findPermutation(String s) {
        s = s + ".";
        int[] permutation = new int[s.length()];
        int count = 1, i = 0;

        while (i < permutation.length) {
            if (s.charAt(i) != 'D') {
                permutation[i++] = count++;
            } else {
                int right = i;
                while (s.charAt(right) == 'D') {
                    right++;
                }
                for (int j = right; j >= i; j--) {
                    permutation[j] = count++;
                }
                i = right + 1;
            }
        }
        return permutation;
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

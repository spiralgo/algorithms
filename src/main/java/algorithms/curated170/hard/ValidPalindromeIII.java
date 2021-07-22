package algorithms.curated170.hard;

import java.util.Arrays;

public class ValidPalindromeIII {
    
    public boolean isValidPalindrome(String s, int k) {
        int len = s.length();
        char[] data = s.toCharArray();
        int[] maxPalindromicSubsequences = new int[len];
        Arrays.fill(maxPalindromicSubsequences, 1);
        int maxPalindrome = 1;

        for (int i = 0; i < len; i++) {
            int maxSubseqBetween = 0;
            for (int j = i - 1; j >= 0; j--) {
                int subseqLength = maxPalindromicSubsequences[j];

                if (data[i] == data[j]) {
                    maxPalindromicSubsequences[j] = maxSubseqBetween + 2;
                    maxPalindrome = Math.max(maxPalindrome, maxPalindromicSubsequences[j]);
                }

                maxSubseqBetween = Math.max(subseqLength, maxSubseqBetween);
            }
        }

        return maxPalindrome >= len - k;
    }

    public static void main(String[] args) {
        var solution = new ValidPalindromeIII();

        System.out.println(solution.isValidPalindrome("sqreparqs", 2)); // true
        System.out.println(solution.isValidPalindrome("sqreparqsf", 2)); // false
    }
}

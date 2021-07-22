package algorithms.curated170.hard;

public class HandshakesThatDontCross {
    public boolean isValidPalindrome(String s, int k) {
        char[] data = s.toCharArray();
        int[] dp = new int[data.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < dp.length; i++ ) {
            int maxSoFar = 0;
            for (int j = i - 1; j >= 0; j--) {
                int temp = dp[j];
                if (data[i] == data[j]) {
                    dp[j] = maxSoFar + 2;
                    res = Math.max(res, dp[j]);
                }
                maxSoFar = Math.max(temp, maxSoFar);
            }
        }
        return s.length() - k <= res;
    }
}

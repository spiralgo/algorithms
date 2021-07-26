package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class EncodeStringWithShortestLengthDP {
    
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        for (int j = 0; j < n; ++j) {

            dp[j][j] = s.substring(j, j + 1);
            for (int p = 0; p < j; p++) {
                dp[p][j] = dp[p][j - 1] + dp[j][j];
            }

            for (int i = j - 1; 2*i >= j - 1; --i) {
                String sub = s.substring(i + 1, j + 1); // s[i+1..j]
                for (int k = 2*i - (j - 1); k >= 0 && sub.equals(s.substring(k, k + j - i)); k -= j - i) {
                    String str = String.valueOf((j + 1 - k) / (j - i)) + "[" + dp[i + 1][j] + "]";
                    if (str.length() < dp[k][j].length()) {
                        dp[k][j] = str;
                        
                        for (int p = 0; p < k; ++p) {
                            if (dp[p][k - 1].length() + str.length() < dp[p][j].length()) {
                                dp[p][j] = dp[p][k - 1] + str;
                            }
                        }
                        
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

}
package algorithms.curated170.hard;

import java.util.HashMap;

public class EncodeStringWithShortestLength {
    HashMap<String, String> map;

    public String encode(String s) {
        map = new HashMap<>();
        return buildEncodedStr(s);
    }

    private String buildEncodedStr(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        char[] c = s.toCharArray();
        String[][] ss = new String[c.length][c.length];
        for (int i = 0; i < c.length; i++) {
            int[] next = new int[c.length - i + 1];
            next[0] = -1;
            int repLen = -1;
            for (int j = 0; j + i < c.length; j++) {
                while (repLen != -1 && c[j + i] != c[repLen + i]) {
                    repLen = next[repLen];
                }
                next[j + 1] = repLen++;
                int dup = repLen > 0 && (j + 1) % (j + 1 - repLen) == 0 ? j + 1 - repLen : j + 1;
                if (dup == j + 1) {
                    ss[i][i + j] = s.substring(i, i + j + 1);
                } else {
                    String s1 = String.valueOf((j + 1) / dup) + "[" + buildEncodedStr(s.substring(i, i + dup)) + "]";
                    ss[i][i + j] = s1.length() < j + 1 ? s1 : s.substring(i, i + j + 1);
                }
            }
        }
        int[] dp = new int[c.length + 1];
        int[] prev = new int[c.length + 1];
        for (int i = 0; i < c.length; i++) {
            dp[i + 1] = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (dp[j] + ss[j][i].length() < dp[i + 1]) {
                    dp[i + 1] = dp[j] + ss[j][i].length();
                    prev[i + 1] = j;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        int cur = c.length;
        while (cur > 0) {
            int p = prev[cur];
            sb.insert(0, ss[p][cur - 1]);
            cur = p;
        }
        map.put(s, sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        var solution = new EncodeStringWithShortestLength();

        System.out.println(solution.encode("abbbbb"));
        System.out.println(solution.map);
        /*
        System.out.println(solution.encode("abcbcbce"));
        System.out.println(solution.map);
        
        System.out.println(solution.encode("spiralgospiralgospiralgospiralgo"));
        System.out.println(solution.map);

        System.out.println(solution.encode("abbbbbabbbbbabbbbbcd"));
        System.out.println(solution.map);
        */
    }
}
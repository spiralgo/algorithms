package algorithms.curated170.hard;

import java.util.HashMap;

public class EncodeStringWithShortestLength {
    HashMap<String, String> encodeMap;

    public String encode(String s) {
        encodeMap = new HashMap<>();
        return buildEncodedStr(s);
    }

    private String buildEncodedStr(String s) {
        if (encodeMap.containsKey(s)) {
            return encodeMap.get(s);
        }
        char[] data = s.toCharArray();
        int len = data.length;
        String[][] ss = produce(s, data, len);

        int[] dp = new int[len + 1];
        int[] prev = new int[len + 1];
        for (int i = 0; i < len; i++) {
            dp[i + 1] = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (dp[j] + ss[j][i].length() < dp[i + 1]) {
                    dp[i + 1] = dp[j] + ss[j][i].length();
                    prev[i + 1] = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur = len;
        while (cur > 0) {
            int p = prev[cur];
            sb.insert(0, ss[p][cur - 1]);
            cur = p;
        }
        encodeMap.put(s, sb.toString());
        return sb.toString();
    }

    private String[][] produce(String s, char[] data, int len) {
        String[][] ss = new String[len][len];

        for (int i = 0; i < len; i++) {
            int[] preStartIdx = new int[len - i + 1];
            preStartIdx[0] = -1;
            int repHeadLen = -1;
            for (int j = 0; j + i < len; j++) {
                repHeadLen = findRepetitionStart(data, i, preStartIdx, repHeadLen, j);

                int totalCodeLen = j + 1;
                preStartIdx[totalCodeLen] = ++repHeadLen;

                int encodedStrLen = hasMultipleOfSubstr(repHeadLen, totalCodeLen) ? totalCodeLen - repHeadLen
                        : totalCodeLen;

                if (encodedStrLen == totalCodeLen || totalCodeLen < 5) {
                    ss[i][i + j] = s.substring(i, i + totalCodeLen);
                } else {
                    String encodedSubstr = deliverEncodedSubstr(s, i, totalCodeLen, encodedStrLen);
                    ss[i][i + j] = encodedSubstr.length() < totalCodeLen ? encodedSubstr
                            : s.substring(i, i + totalCodeLen);
                }
            }
        }

        return ss;
    }

    private int findRepetitionStart(char[] c, int i, int[] preStartIdx, int repHeadLen, int j) {
        while (repHeadLen != -1 && c[j + i] != c[repHeadLen + i]) {
            repHeadLen = preStartIdx[repHeadLen];
        }
        return repHeadLen;
    }

    private String deliverEncodedSubstr(String s, int i, int totalCodeLen, int encodedStrLen) {
        return String.valueOf(totalCodeLen / encodedStrLen) + "[" + buildEncodedStr(s.substring(i, i + encodedStrLen))
                + "]";
    }

    private boolean hasMultipleOfSubstr(int repHeadLen, int totalCodeLen) {
        return repHeadLen > 0 && totalCodeLen % (totalCodeLen - repHeadLen) == 0;
    }

    public static void main(String[] args) {
        var solution = new EncodeStringWithShortestLength();

        System.out.println(solution.encode("abababfabababf"));
        System.out.println(solution.encodeMap);

        /*
         * System.out.println(solution.encode("abcdabcd"));
         * System.out.println(solution.map);
         * 
         * System.out.println(solution.encode("abcbcbce"));
         * System.out.println(solution.map);
         * 
         * System.out.println(solution.encode("spiralgospiralgospiralgospiralgo"));
         * System.out.println(solution.map);
         * 
         * System.out.println(solution.encode("abbbbbabbbbbabbbbbcd"));
         * System.out.println(solution.map);
         */
    }
}
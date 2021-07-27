package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
        if (len < 5) {
            return s;
        }

        String[][] codings = assembleEncodings(s, data, len);

        int[] codeIdxRanges = calculateCodeRanges(len, codings);

        StringBuilder sb = traceBackCodings(len, codings, codeIdxRanges);

        encodeMap.put(s, sb.toString());
        return sb.toString();
    }

    private StringBuilder traceBackCodings(int len, String[][] codings, int[] codeIdxRanges) {
        List<String> validCodingsReverse = new ArrayList<>();
        int curEnd = len;

        while (curEnd > 0) {
            int start = codeIdxRanges[curEnd];
            validCodingsReverse.add(codings[start][curEnd - 1]);
            curEnd = start;
        }

        StringBuilder sb = new StringBuilder();
        for (int a = validCodingsReverse.size() - 1; a >= 0; a--) {
            sb.append(validCodingsReverse.get(a));
        }

        return sb;
    }

    private int[] calculateCodeRanges(int len, String[][] codings) {
        int[] codeIdxRanges = new int[len + 1];
        int[] minCodeLen = new int[len + 1];
        for (int end = 0; end < len; end++) {
            minCodeLen[end + 1] = Integer.MAX_VALUE;
            for (int start = 0; start <= end; start++) {
                if (minCodeLen[start] + codings[start][end].length() < minCodeLen[end + 1]) {
                    minCodeLen[end + 1] = minCodeLen[start] + codings[start][end].length();
                    codeIdxRanges[end + 1] = start;
                }
            }
        }
        return codeIdxRanges;
    }

    private String[][] assembleEncodings(String s, char[] data, int len) {
        String[][] codings = new String[len][len];

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
                    codings[i][i + j] = s.substring(i, i + totalCodeLen);
                } else {
                    String encodedSubstr = deliverEncodedSubstr(s, i, totalCodeLen, encodedStrLen);
                    codings[i][i + j] = encodedSubstr.length() < totalCodeLen ? encodedSubstr
                            : s.substring(i, i + totalCodeLen);
                }
            }
        }

        return codings;
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

        System.out.println(solution.encode("abababaabababab"));
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
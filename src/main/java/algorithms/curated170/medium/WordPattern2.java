package algorithms.curated170.medium;

import java.util.HashSet;

public class WordPattern2 {

    String[] mapMatches;
    HashSet<String> setMatches;
    String pattern, str;

    public boolean wordPatternMatch(String pattern, String str) {
        mapMatches = new String[26]; 
        setMatches = new HashSet<>(); 
        this.pattern = pattern;
        this.str = str;
        return backtrackPatternMatch(0, str.length() - 1, 0, pattern.length() - 1);
    }

    private boolean backtrackPatternMatch(int start, int end, int pStart, int pEnd) {

        if (pStart == pEnd + 1 && start == end + 1) {
            return true;
        } else if ((pStart > pEnd) || (start > end)) {
            return false;
        }

        char ch = pattern.charAt(pStart);
        int chIdx = letterIndex(ch);
        String matched = mapMatches[chIdx];

        if (matched != null) {
            return isValidMatch(start, end, pStart, pEnd, matched);
        }

        return isPossibleToMatch(start, end, pStart, pEnd, chIdx);
    }

    private boolean isPossibleToMatch(int start, int end, int pStart, int pEnd, int chIdx) {
        
        int unmatchedEndPos = findLastUnmatchedPos(end, pStart, pEnd);
        
        for (int i = start; i <= unmatchedEndPos; i++) {

            String matched = str.substring(start, i + 1);

            if (setMatches.contains(matched)) {
                continue;
            }

            mapMatches[chIdx] = matched;
            setMatches.add(matched);

            if (backtrackPatternMatch(i + 1, end, pStart + 1, pEnd)) {
                return true;
            } else {
                cleanPossibleMatch(chIdx, matched);
            }
        }

        return false;
    }

    private int findLastUnmatchedPos(int end, int pStart, int pEnd) {
        int unmatchedEndPos = end;

        for (int i = pEnd; i > pStart; i--) {
            unmatchedEndPos -= patternsToMatch(i);
        }
        return unmatchedEndPos;
    }

    private int patternsToMatch(int i) {
        return mapMatches[letterIndex(pattern.charAt(i))] == null ? 1
                : mapMatches[letterIndex(pattern.charAt(i))].length();
    }

    private boolean isValidMatch(int start, int end, int pStart, int pEnd, String matched) {
        int lengthMatchedStr = matched.length();
        return start + lengthMatchedStr <= end + 1 && matched.equals(str.substring(start, start + lengthMatchedStr))
                && backtrackPatternMatch(start + lengthMatchedStr, end, pStart + 1, pEnd);
    }

    private void cleanPossibleMatch(int chIdx, String matched) {
        mapMatches[chIdx] = null;
        setMatches.remove(matched);
    }

    private final int LETTER_a = 97;

    private int letterIndex(char ch) {
        return ch - LETTER_a;
    }

    public static void main(String[] args) {

        var solution = new WordPattern2();

        System.out.println(solution.wordPatternMatch("ab", "redblue")); // r_edblue
        System.out.println(solution.wordPatternMatch("aba", "redbluered")); // red_blue_red

        System.out.println(solution.wordPatternMatch("abac", "wwssswwqq"));

        System.out.println(solution.wordPatternMatch("ababe", "flygoflygorun"));

        System.out.println(solution.wordPatternMatch("abba", "wwwwwwwwww")); // ww_www_www_ww
        System.out.println(solution.wordPatternMatch("abab", "wwww")); 

        System.out.println(solution.wordPatternMatch("rllr", "leftrightleftright"));

    }
}
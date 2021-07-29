package algorithms.curated170.hard;

public class MinimumWindowSubsequenceDP {

    private static final int NO_POS = -1;

    public String minWindow(String S, String T) {

        int[] startIdx = new int[S.length() + 1];
        for (int i = 0; i < startIdx.length; i++)
            startIdx[i] = i;

        for (int t = 1; t <= T.length(); t++) {
            int[] nextCharStartIdx = new int[S.length() + 1];
            findSequenceStartForNextChar(S, T, startIdx, t, nextCharStartIdx);

            if(nextCharStartIdx[S.length()] == -1) return "";

            startIdx = nextCharStartIdx;
        }

        int start = -1, end = -1, len = S.length() + 1;
        for (int i = 1; i < startIdx.length; i++) {
            
            if (startIdx[i] != NO_POS && i - startIdx[i] < len) {
                start = startIdx[i];
                end = i;
                len = end - start;
            }
        }

        return S.substring(start, end);
    }

    private void findSequenceStartForNextChar(String S, String T, int[] startIdx, int t, int[] nextCharStartIdx) {
        nextCharStartIdx[0] = NO_POS; 
        for (int s = 1; s <= S.length(); s++) {
            nextCharStartIdx[s] = (S.charAt(s - 1) == T.charAt(t - 1)) ? startIdx[s - 1] : nextCharStartIdx[s - 1];
        }
    }

}
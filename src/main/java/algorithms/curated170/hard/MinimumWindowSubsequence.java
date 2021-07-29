package algorithms.curated170.hard;

public class MinimumWindowSubsequence {

    private static final int NO_POS = -1;

    public String minWindow(String S, String T) {
        int i = NO_POS;
        String minWin = "";
        char[] dataT = T.toCharArray();
        int tLen = dataT.length;

        while (true) {
            for (char c : dataT) {
                i = S.indexOf(c, i + 1);
                if (i == NO_POS) {
                    return minWin;
                }
            }

            int end = ++i;
            for (int j = tLen - 1; j >= 0; j--) {
                i = S.lastIndexOf(dataT[j], i - 1);
            }
            if (minWin == "" || minWin.length() > end - i) {
                minWin = S.substring(i++, end);
            }
        }
    }

}
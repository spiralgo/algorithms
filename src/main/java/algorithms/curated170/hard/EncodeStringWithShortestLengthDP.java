package algorithms.curated170.hard;

public class EncodeStringWithShortestLengthDP {

    public String encode(String s) {
        int n = s.length();
        String[][] codings = new String[n][n];

        for (int e = 0; e < n; e++) {

            initializeEndings(s, codings, e);

            for (int b = e - 1; b - (e - b) + 1 >= 0; --b) {
                String pattern = s.substring(b + 1, e + 1);
                int patternLen = e - b;

                int maxRepStartIdx = b - patternLen + 1;
                for (int repStart = maxRepStartIdx; repStart >= 0
                        && pattern.equals(s.substring(repStart, repStart + patternLen)); repStart -= patternLen) {

                    String str = String.valueOf((e - repStart + 1) / patternLen) + "[" + codings[b + 1][e] + "]";

                    updatePreviousCodings(codings, e, repStart, str);
                }
            }
        }

        return codings[0][n - 1];
    }

    private void initializeEndings(String s, String[][] codings, int e) {
        codings[e][e] = s.substring(e, e + 1);
        for (int i = 0; i < e; i++) {
            codings[i][e] = codings[i][e - 1] + codings[e][e];
        }
    }

    private void updatePreviousCodings(String[][] codings, int e, int repStart, String str) {
        if (str.length() < codings[repStart][e].length()) {
            codings[repStart][e] = str;

            for (int u = 0; u < repStart; u++) {
                if (codings[u][repStart - 1].length() + str.length() < codings[u][e].length()) {
                    codings[u][e] = codings[u][repStart - 1] + str;
                }
            }

        }
    }

    public static void main(String[] args) {
        var solution = new EncodeStringWithShortestLengthDP();

        System.out.println(solution.encode("abababab"));
    }
}
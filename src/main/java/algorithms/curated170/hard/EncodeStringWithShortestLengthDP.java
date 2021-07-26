package algorithms.curated170.hard;

public class EncodeStringWithShortestLengthDP {

    public String encode(String s) {
        int n = s.length();
        String[][] codings = new String[n][n];
        for (int e = 0; e < n; e++) {

            initializeEndings(s, codings, e);

            for (int b = e - 1; 2 * b >= e - 1; --b) {
                String sub = s.substring(b + 1, e + 1);
                int encodedStrLen = e - b;
                
                for (int repStart = 2 * b - (e - 1); repStart >= 0 && sub.equals(s.substring(repStart, repStart + encodedStrLen)); repStart -= encodedStrLen) {

                    String str = String.valueOf((e - repStart + 1) / encodedStrLen) + "[" + codings[b + 1][e] + "]";
                    
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
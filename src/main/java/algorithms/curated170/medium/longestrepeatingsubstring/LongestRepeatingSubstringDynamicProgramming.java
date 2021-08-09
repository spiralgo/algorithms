package algorithms.curated170.medium.longestrepeatingsubstring;

public class LongestRepeatingSubstringDynamicProgramming {

  public int longestRepeatingSubstring(String S) {
    int n = S.length();
    int[][] repLength = new int[n + 1][n + 1];
    int longest = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {

        if (S.charAt(i - 1) == S.charAt(j - 1)) {
          repLength[i][j] = repLength[i - 1][j - 1] + 1;
          longest = Math.max(longest, repLength[i][j]);
        }

      }
    }

    return longest;
  }

  public static void main(String[] args) {
    var longestRepeatingSubstring = new LongestRepeatingSubstringDynamicProgramming();
    int result = longestRepeatingSubstring.longestRepeatingSubstring("aaaaaaaaaaaaaaaa");
    System.out.println(result);
  }
}
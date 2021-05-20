package algorithms.curated170.medium.generalizedabbreviation;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviationBacktracking {

    List<String> ans = new ArrayList<>();
    String word;
    StringBuilder sb;
    public List<String> generateAbbreviations(String word) {
        ans = new ArrayList<String>();
        this.word = word;
        sb = new StringBuilder();

        backtrack(0, 0);
        return ans;
    }

    // i is the current index at the string
    // k is the count of consecutive abbreviations
    private void backtrack(int i, int count) {
        int len = sb.length(); // keep the length to reset
        if (i == word.length()) {
            if (count != 0) {
                sb.append(count); // append nums
            }
            ans.add(sb.toString());
        } else {
            // the branch that abbreviates word.charAt(i) 
            backtrack(i + 1, count + 1);

            // the branch that keeps word.charAt(i) 
            if (count != 0) {
                sb.append(count);
            }
            sb.append(word.charAt(i));
            backtrack(i + 1, 0);
        }
        sb.setLength(len); // reset sb by trimming newly added chars
    }

    public static void main(String[] args) {
        var solution = new GeneralizedAbbreviationBacktracking();
        String s = "abc";
        var a = solution.generateAbbreviations(s);
        System.out.println(a);
    }
}
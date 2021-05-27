package algorithms.curated170.medium.generalizedabbreviation;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviationBacktracking {

    List<String> abbreviations = new ArrayList<>();
    String word;
    StringBuilder sb;
    
    public List<String> generateAbbreviations(String word) {
        abbreviations = new ArrayList<String>();
        this.word = word;
        sb = new StringBuilder();

        backtrack(0, 0);
        return abbreviations;
    }

    private void backtrack(int i, int count) {
        int len = sb.length();
        if (i == word.length()) {
            if (count != 0) {
                sb.append(count); 
            }
            abbreviations.add(sb.toString());
        } else {
            
            backtrack(i + 1, count + 1);

            if (count != 0) {
                sb.append(count);
            }
            sb.append(word.charAt(i));
            backtrack(i + 1, 0);
        }
        resetStringBranch(len);
    }

    private void resetStringBranch(int len)
    {
        sb.setLength(len); 
    }

    public static void main(String[] args) {
        var solution = new GeneralizedAbbreviationBacktracking();
        String s = "abc";
        var a = solution.generateAbbreviations(s);
        System.out.println(a);
    }
}
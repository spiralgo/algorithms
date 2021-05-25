package algorithms.curated170.medium.generalizedabbreviation;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviationBitwise {

    int wordLength;
    String word;

    public List<String> generateAbbreviations(String word) {
        this.word = word;
        wordLength = word.length();
        List<String> abbreviations = new ArrayList<>();
        final int bitSetLimit = 1 << wordLength;

        for (int key = 0; key < bitSetLimit; key++) {
            abbreviations.add(abbreviate(key));
        }
        return abbreviations;
    }

    private String abbreviate(int key) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < wordLength; i++, key >>= 1) {
            if ((key & 1) == 0) {
                if (count != 0) {
                    sb.append(count);
                    count = 0;
                }
                sb.append(word.charAt(i));
            } else {
                count++;
            }
        }
        if (count != 0) {
            sb.append(count);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var solution = new GeneralizedAbbreviationBitwise();
        String s = "string";
        var a = solution.generateAbbreviations(s);
        System.out.println(a);
    }
}
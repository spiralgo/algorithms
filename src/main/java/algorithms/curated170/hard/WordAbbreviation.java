package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordAbbreviation {

    public List<String> wordsAbbreviation(List<String> words) {
        int len = words.size();
        String[] res = new String[len];
        int[] prefix = new int[len];
        HashMap<String, List<Integer>> abbreviationIndices = new HashMap<>();

        initializeAbbreviations(words, len, res, abbreviationIndices);

        handleDuplicates(words, len, res, prefix, abbreviationIndices);

        return Arrays.asList(res);
    }

    private void handleDuplicates(List<String> words, int len, String[] abbr, int[] prefix,
            HashMap<String, List<Integer>> abbreviationIndices) {

        for (int i = 0; i < len; i++) {
            if (abbreviationIndices.get(abbr[i]).size() == 1) {
                continue;
            }
            distributeNewAbbreviations(words, abbr, prefix, abbreviationIndices, i);
            i--;
        }
    }

    private void distributeNewAbbreviations(List<String> words, String[] res, int[] prefixLength,
            HashMap<String, List<Integer>> abbreviationIndices, int i) {

        List<Integer> indices = abbreviationIndices.get(res[i]);
        abbreviationIndices.remove(res[i]);

        for (int j : indices) {
            prefixLength[j]++;
            res[j] = makeAbbr(words.get(j), prefixLength[j]);
            abbreviationIndices.putIfAbsent(res[j], new ArrayList<>());
            abbreviationIndices.get(res[j]).add(j);
        }
    }

    private void initializeAbbreviations(List<String> words, int len, String[] res,
            HashMap<String, List<Integer>> abbreviationIndices) {
        for (int i = 0; i < len; i++) {
            res[i] = makeAbbr(words.get(i), 1);
            abbreviationIndices.putIfAbsent(res[i], new ArrayList<>());
            abbreviationIndices.get(res[i]).add(i);
        }
    }

    private String makeAbbr(String s, int k) {
        if (k >= s.length() - 2)
            return s;
        StringBuilder builder = new StringBuilder();
        builder.append(s.substring(0, k));
        builder.append(s.length() - 1 - k);
        builder.append(s.charAt(s.length() - 1));
        return builder.toString();
    }
}
package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordAbbreviation {

    public List<String> wordsAbbreviation(List<String> words) {
        int len = words.size();
        String[] abbr = new String[len];
        int[] prefixLength = new int[len];
        HashMap<String, List<Integer>> abbreviationIndices = new HashMap<>();

        initializeAbbreviations(words, len, abbr, abbreviationIndices);

        handleDuplicates(words, len, abbr, prefixLength, abbreviationIndices);

        return Arrays.asList(abbr);
    }

    private void handleDuplicates(List<String> words, int len, String[] abbr, int[] prefixLength,
            HashMap<String, List<Integer>> abbreviationIndices) {

        for (int i = 0; i < len; i++) {
            if (abbreviationIndices.get(abbr[i]).size() == 1) {
                continue;
            }
            distributeNewAbbreviations(words, abbr, prefixLength, abbreviationIndices, i);
            i--;
        }
    }

    private void distributeNewAbbreviations(List<String> words, String[] abbr, int[] prefixLength,
            HashMap<String, List<Integer>> abbreviationIndices, int i) {

        List<Integer> indices = abbreviationIndices.get(abbr[i]);
        abbreviationIndices.remove(abbr[i]);

        for (int j : indices) {
            prefixLength[j]++;
            abbr[j] = makeAbbr(words.get(j), prefixLength[j]);
            abbreviationIndices.putIfAbsent(abbr[j], new ArrayList<>());
            abbreviationIndices.get(abbr[j]).add(j);
        }
    }

    private void initializeAbbreviations(List<String> words, int len, String[] abbr,
            HashMap<String, List<Integer>> abbreviationIndices) {
        for (int i = 0; i < len; i++) {
            abbr[i] = makeAbbr(words.get(i), 1);
            abbreviationIndices.putIfAbsent(abbr[i], new ArrayList<>());
            abbreviationIndices.get(abbr[i]).add(i);
        }
    }

    private String makeAbbr(String s, int k) {
        if (k >= s.length() - 2)
            return s;
        StringBuilder abbreviation = new StringBuilder();
        abbreviation.append(s.substring(0, k));
        abbreviation.append(s.length() - 1 - k);
        abbreviation.append(s.charAt(s.length() - 1));
        return abbreviation.toString();
    }
}
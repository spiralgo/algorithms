package algorithms.curated170.easy.sentencesimilarity;

public class SentenceSimilarityFaster {

    class Solution {

        public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
            if (sentence1.length != sentence2.length) {
                return false;
            }
            for (int i = 0; i < sentence1.length; i++) {
                if (!check(sentence1[i], sentence2[i], similarPairs)) {
                    return false;
                }
            }
            return true;
        }

        public boolean check(String s1, String s2, List<List<String>> similarPairs) {
            if (s1.equals(s2)) {
                return true;
            }
            for (int i = 0; i < similarPairs.size(); i++) {
                if (similarPairs.get(i).get(0).equals(s1)) {
                    if (similarPairs.get(i).get(1).equals(s2)) {
                        return true;
                    }
                } else if (similarPairs.get(i).get(0).equals(s2)) {
                    if (similarPairs.get(i).get(1).equals(s1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

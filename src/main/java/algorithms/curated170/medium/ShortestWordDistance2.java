package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance2 {

    public class WordDistance {

        HashMap<String, List<Integer>> wordIndices;

        public WordDistance(String[] words) {
            wordIndices = new HashMap<String, List<Integer>>();

            for (int i = 0; i < words.length; i++) {
                if (!wordIndices.containsKey(words[i])) {
                    wordIndices.put(words[i], new ArrayList<Integer>());
                }
                wordIndices.get(words[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> ind1 = wordIndices.get(word1);
            List<Integer> ind2 = wordIndices.get(word2);
            int minDist = wordIndices.size();
            int i = 0, j = 0;
            while (i < ind1.size() && j < ind2.size()) {
                int i1 = ind1.get(i);
                int i2 = ind2.get(j);
                int currDist = i1 - i2;

                minDist = Math.min(minDist, Math.abs(currDist));

                if (currDist == 0) {
                    return 0;
                } else if (currDist < 0) {
                    i++;
                } else {
                    j++;
                }
            }
            return minDist;
        }
    }

    public static void main(String[] args) {

    }

}

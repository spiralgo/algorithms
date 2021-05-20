package algorithms.curated170.easy.sentencesimilarity;
 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SentenceSimilarity {
 public boolean areSentencesSimilar(
            String[] words1, String[] words2,List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        Set<String> pairset = new HashSet();
        for (List<String> pair: pairs)
            pairset.add(pair.get(0) + "#" + pair.get(1));

        for (int i = 0; i < words1.length; ++i) {
            if (!words1[i].equals(words2[i]) &&
                    !pairset.contains(words1[i] + "#" + words2[i]) &&
                    !pairset.contains(words2[i] + "#" + words1[i]))
                return false;
        }
        return true;
    }
  public boolean areSentencesSimilarWithoutConcatination(
            String[] words1, String[] words2,List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        Set<List<String>> pairset = new HashSet<>();
        for (List<String> pair: pairs)
            pairset.add(pair);

        for (int i = 0; i < words1.length; ++i) {
            if (!words1[i].equals(words2[i]) &&
                    !pairset.contains(List.of(words1[i], words2[i])) &&
                    !pairset.contains(List.of(words2[i], words1[i])))
                return false;
        }
        return true;
    }
}
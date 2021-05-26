package algorithms.curated170.medium.sentencesimilarity2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

 
public class SentenceSimilarityIIUnionFindMap {
  Map<String, String> parent = new HashMap();

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        for (List<String> pair : pairs) {

            for (String p : pair) {
                parent.put(p, p);
            }
        }
        for (List<String> pair : pairs) {

            union(pair.get(0), pair.get(1));
        }
        for (int i = 0; i < words1.length; ++i) {

            String w1 = words1[i], w2 = words2[i];
            String parentWord1 = find(w1);
            String parentWord2 = find(w2);
            if (!parentWord1.equals(parentWord2)) {
                return false;
            }
        }
        return true;
    }

    String find(String w1) {
        if(!parent.containsKey(w1)) return w1;
        String parentWord = parent.get(w1);
        if (parentWord.equals(w1)) {
            return w1;
        }
        return find(parentWord);
    }

    void union(String w1, String w2) {
        String parentWord1 = find(w1);
        String parentWord2 = find(w2);
 
        if (!parentWord1.equals(parentWord2)) {
            parent.put(find(w1), find(w2));
        }
    }

}

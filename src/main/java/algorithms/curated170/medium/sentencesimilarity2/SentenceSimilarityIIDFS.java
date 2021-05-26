package algorithms.curated170.medium.sentencesimilarity2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SentenceSimilarityIIDFS {

    Map<String, List<String>> graph;
    HashSet<String> visited;

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        graph = new HashMap();

        for (List<String> pair : pairs) {
            for (String p : pair) {
                if (!graph.containsKey(p)) {
                    graph.put(p, new ArrayList());
                }
            }
            graph.get(pair.get(0)).add(pair.get(1));
            graph.get(pair.get(1)).add(pair.get(0));
        }
        for (int i = 0; i < words1.length; ++i) {
            visited = new HashSet();
            String w1 = words1[i], w2 = words2[i];
            if (!dfs(w1, w2)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(String w1, String w2) {

        visited.add(w2);
        if (w1.equals(w2)) {
            return true;
        }

        if (graph.containsKey(w2)) {
            List<String> connectedWords = graph.get(w2);
            for (String word : connectedWords) {
                if (!visited.contains(word) && dfs(w1, word)) {
                    return true;
                }
            }
        }

        return false;
    }

}

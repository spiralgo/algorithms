package algorithms.curated170.medium.shortestworddistance3;

public class ShortestWordDistance3GeneralizedCases {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx = -1, res = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (idx != -1 && (same || !words[i].equals(words[idx]))) {
                    res = Math.min(res, i - idx);
                }
                idx = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        var solution = new ShortestWordDistance3GeneralizedCases();
        String[] words = { "practice", "makes", "perfect", "coding", "makes" };
        System.out.println(solution.shortestWordDistance(words, new String("makes"), new String("makes"))); // prints 3
        System.out.println(solution.shortestWordDistance(words, "coding", "makes")); // prints 1
    }
}

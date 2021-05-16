package algorithms.curated170.easy;

public class ShortestWordDistance3 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDist = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) && (i1 < 0 || words[i1] != word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDist = Math.min(minDist, Math.abs(i1 - i2));
            }
        }
        return minDist;
    }

    public static void main(String[] args) {

        var solution = new ShortestWordDistance3();
        String[] words = { "practice", "makes", "perfect", "coding", "makes" };
        System.out.println(solution.shortestDistance(words, "makes", "makes")); // prints 3
        System.out.println(solution.shortestDistance(words, "coding", "makes")); // prints 1
    }
}

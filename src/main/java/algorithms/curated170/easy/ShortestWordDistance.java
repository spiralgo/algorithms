package algorithms.curated170.easy;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDist = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
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
        ShortestWordDistance solution = new ShortestWordDistance();

        // Test sample 1
        String[] words1 = {"practice", "makes", "perfect", "coding", "makes"};
        String word1Sample1 = "coding";
        String word2Sample1 = "practice";
        System.out.println("Shortest distance between 'coding' and 'practice': " + solution.shortestDistance(words1, word1Sample1, word2Sample1));

        // Test sample 2
        String word1Sample2 = "makes";
        String word2Sample2 = "coding";
        System.out.println("Shortest distance between 'makes' and 'coding': " + solution.shortestDistance(words1, word1Sample2, word2Sample2));

        // Test sample 3
        String[] words2 = {"a", "c", "b", "a"};
        String word1Sample3 = "a";
        String word2Sample3 = "b";
        System.out.println("Shortest distance between 'a' and 'b': " + solution.shortestDistance(words2, word1Sample3, word2Sample3));

        // Test sample 4
        String[] words3 = {"a", "a", "b", "b"};
        String word1Sample4 = "a";
        String word2Sample4 = "b";
        System.out.println("Shortest distance between 'a' and 'b': " + solution.shortestDistance(words3, word1Sample4, word2Sample4));
    }
}

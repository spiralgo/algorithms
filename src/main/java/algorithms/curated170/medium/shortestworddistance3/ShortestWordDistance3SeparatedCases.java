package algorithms.curated170.medium;

public class ShortestWordDistance3SeparatedCases {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        return word1.equals(word2) ? minimumFromEqualStrings(wordsDict, word1) : minimumFromUnequalStrings(wordsDict, word1, word2);
    }

    private int minimumFromEqualStrings(String[] wordsDict, String word1) {
        int min = Integer.MAX_VALUE;
        int prevIndex = -1;
        for(int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)) {
                if(prevIndex != -1) {
                    min = Math.min(min, i - prevIndex);
                }
                prevIndex = i;
            }
        }
        return min;
    }

    private int minimumFromUnequalStrings(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int w1Index = -1;
        int w2Index = -1;
        for(int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)) {
                if(w2Index != -1) {
                    min = Math.min(min, i - w2Index);
                }
                w1Index = i;
            } else if(wordsDict[i].equals(word2)) {
                if(w1Index != -1) {
                    min = Math.min(min, i - w1Index);
                }
                w2Index = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        var solution = new ShortestWordDistance3SeparatedCases();
        String[] words = { "practice", "makes", "perfect", "coding", "makes" };
        System.out.println(solution.shortestWordDistance(words, new String("makes"), new String("makes"))); // prints 3
        System.out.println(solution.shortestWordDistance(words, "coding", "makes")); // prints 1
    }
}

package algorithms.curated170.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AlienDictionaryDFS {

    private static final int ALPHABET_SIZE = 26;
    int[] outDegree;
    int[] inDegree;
    boolean[] hasLetter;
    int charCount;
    boolean[] visiting;
    boolean[] checked;
    int orderIdx;

    public String alienOrder(String[] words) {
        countLetters(words);

        List<int[]> arcs = createArcs(words);
        if (arcs == null) {
            return "";
        }

        int[][] digraph = makeGraph(arcs);
        checked = new boolean[ALPHABET_SIZE];
        visiting = new boolean[ALPHABET_SIZE];
        char[] order = new char[charCount];
        orderIdx = charCount;

        for (int c = 0; c < ALPHABET_SIZE; c++) {
            if (hasLetter[c] && !checked[c]) {
                if (!hasNoCycle(digraph, c, order)) {
                    return "";
                }
            }
        }

        return new String(order);
    }

    private void countLetters(String[] words) {
        hasLetter = new boolean[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                hasLetter[c - 'a'] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (hasLetter[i]) {
                charCount++;
            }
        }

    }

    private List<int[]> createArcs(String[] words) {
        List<int[]> arcs = new ArrayList<>();
        outDegree = new int[26];
        inDegree = new int[26];

        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            if (!a.equals(b) && a.startsWith(b)) {
                return null;
            }

            int j = 0;
            int len = Math.min(a.length(), b.length());

            do {
                int aChar = getIndexOfLetter(a.charAt(j));
                int bChar = getIndexOfLetter(b.charAt(j));

                if (aChar != bChar) {
                    arcs.add(new int[] { aChar, bChar });
                    outDegree[aChar]++;
                    inDegree[bChar]++;
                    break;
                }
                j++;
            } while (j < len);
        }
        return arcs;
    }

    private int[][] makeGraph(List<int[]> arcs) {
        int[][] digraph = new int[ALPHABET_SIZE][];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            digraph[i] = new int[outDegree[i]];
        }

        int[] nextDirectSuccessorIndex = new int[ALPHABET_SIZE];
        for (int[] arc : arcs) {
            digraph[arc[0]][nextDirectSuccessorIndex[arc[0]]++] = arc[1];
        }
        return digraph;
    }

    private boolean hasNoCycle(int[][] digraph, int currLetter, char[] order) {
        if (checked[currLetter]) {
            return true;
        }
        checked[currLetter] = true;

        visiting[currLetter] = true;
        for (int directSuccessor : digraph[currLetter]) {
            if (visiting[directSuccessor] || !hasNoCycle(digraph, directSuccessor, order)) {
                return false;
            }
        }
        order[--orderIdx] = getLetterOfIndex(currLetter);
        visiting[currLetter] = false;

        return true;
    }

    private static final int LETTER_a = 97;

    private static int getIndexOfLetter(char key) {
        return key - LETTER_a;
    }

    private static char getLetterOfIndex(int index) {
        return (char) (LETTER_a + index);
    }

    public static void main(String[] args) {
        var solution = new AlienDictionaryDFS();
        String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
        System.out.println(solution.alienOrder(words));
    }
}

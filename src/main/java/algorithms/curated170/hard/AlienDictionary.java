package algorithms.curated170.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AlienDictionary {

    private static final int ALPHABET_SIZE = 26;
    int[] outDegree;
    int[] inDegree;
    Deque<Integer> currentLetters;
    boolean[] hasLetter;
    int charCount;

    public String alienOrder(String[] words) {
        countLetters(words);

        List<int[]> arcs = createArcs(words);
        if (arcs == null) {
            return "";
        }

        int[][] digraph = makeGraph(arcs);

        initializeFirstLetters();
        return new String(sortTopologically(digraph));
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

    private void initializeFirstLetters() {
        currentLetters = new ArrayDeque<>();

        for (int i = 0; i < 26; i++) {
            if (hasLetter[i] && inDegree[i] == 0) {
                currentLetters.offer(i);
            }
        }
    }

    private char[] sortTopologically(int[][] digraph) {
        int count = 0;
        char[] order = new char[charCount];
        int idx = 0;

        while (!currentLetters.isEmpty()) {
            int letterIdx = currentLetters.poll();
            order[idx++] = getLetterOfIndex(letterIdx);
            for (int nextChar : digraph[letterIdx]) {
                inDegree[nextChar]--;
                if (inDegree[nextChar] == 0) {
                    currentLetters.offer(nextChar);
                }
            }
            count++;
        }

        return count < charCount ? new char[0] : order;
    }

    private static final int LETTER_a = 97;

    private static int getIndexOfLetter(char key) {
        return key - LETTER_a;
    }

    private static char getLetterOfIndex(int index) {
        return (char) (LETTER_a + index);
    }

    public static void main(String[] args) {
        var solution = new AlienDictionary();
        String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
        System.out.println(solution.alienOrder(words));
    }
}

package algorithms.curated170.hard;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlienDictionary {

    int[] inDegree;
    Deque<Integer> currentLetters;
    boolean[] hasLetter;
    int nums;

    public String alienOrder(String[] words) {
        countLetters(words);
        List<int[]> arcs = createArcs(words);
        if (arcs == null) {
            return "";
        }
        int[][] digraph = makeGraph(arcs, 26);
        initializeFirstLetters();
        return new String(sortTopologically(digraph, 26));
    }

    private void initializeFirstLetters() {
        for (int i = 0; i < 26; i++) {
            if (hasLetter[i] && inDegree[i] == 0) {
                currentLetters.offer(i);
            }
        }
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
                nums++;
            }
        }

    }

    private List<int[]> createArcs(String[] words) {
        List<int[]> arcs = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            if (!words[i].equals(words[i + 1]) && words[i].startsWith(words[i + 1])) {
                return null;
            }
            int j = 0;
            int len = Math.min(words[i].length(), words[i + 1].length());
            do {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    arcs.add(new int[] { words[i].charAt(j) - 'a', words[i + 1].charAt(j) - 'a' });
                    break;
                }
                j++;
            } while (j < len);
        }
        return arcs;
    }

    private char[] sortTopologically(int[][] digraph, int n) {

        int count = 0;
        char[] order = new char[this.nums];
        int idx = 0;
        while (!currentLetters.isEmpty()) {
            int node = currentLetters.poll();
            order[idx++] = (char) (node + 'a');
            for (int k : digraph[node]) {
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    currentLetters.offer(k);
                }
            }
            count++;
        }
        if (count < this.nums) {
            return new char[0];
        }
        return order;
    }

    private int[][] makeGraph(List<int[]> arcs, int n) {
        int[] outDegree = new int[n];
        inDegree = new int[n];
        for (int[] arc : arcs) {
            outDegree[arc[0]]++;
            inDegree[arc[1]]++;
        }

        int[][] digraph = new int[n][];
        currentLetters = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            digraph[i] = new int[outDegree[i]];
        }

        int[] nextDirectSuccessorIndex = new int[n];
        for (int[] arc : arcs) {
            digraph[arc[0]][nextDirectSuccessorIndex[arc[0]]++] = arc[1];
        }
        return digraph;
    }

    public static void main(String[] args) {
        var solution = new AlienDictionary();
        String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
        // String[] words = new String[]{"z", "z"};
        System.out.println(solution.alienOrder(words));
    }
}

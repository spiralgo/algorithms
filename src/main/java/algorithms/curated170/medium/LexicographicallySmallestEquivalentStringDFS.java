package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LexicographicallySmallestEquivalentStringDFS {

    private List<Character>[] parent;
    boolean[] seen;

    public String smallestEquivalentString(String A, String B, String S) {
        parent = new ArrayList[26];

        for (int i = 0; i < A.length(); i++) {
            int a = A.charAt(i) - 'a';
            int b = B.charAt(i) - 'a';
            if (parent[a] == null) {
                parent[a] = new ArrayList<>();
            }
            if (parent[b] == null) {
                parent[b] = new ArrayList<>();
            }

            parent[a].add(B.charAt(i));
            parent[b].add(A.charAt(i));
        }
        System.out.println(Arrays.toString(parent));

        StringBuilder sb = new StringBuilder("");
        for (char c : S.toCharArray()) {
            seen = new boolean[26];
            sb.append(DFS(c, c));
        }
        return sb.toString();
    }

    private char DFS(char c, char mn) {

        int charIndex = letterIndex(c);

        if (seen[charIndex]) {
            return mn;
        }
        seen[charIndex] = true;
        char res = mn;
        List<Character> charList = parent[charIndex] == null ? Collections.emptyList() : parent[charIndex]; // or List.of() or new ArrayList<>(). I prefer this, because it is more readable.
        for (char n : charList) 
        {
            mn = seen[letterIndex(n)] ? mn : (char) DFS(n, mn);
        }
        return (char) Math.min(res, (char) Math.min(mn, c));
    }

    public final static int LETTER_a = 97; //ASCII value of 'a'
    private int letterIndex(char ch)
    {
        return (ch - LETTER_a);
    }

    public static void main(String[] args) {

        var solution = new LexicographicallySmallestEquivalentStringDFS();
        String A = "parker", B = "morris", S = "parser";
        System.out.println(solution.smallestEquivalentString(A, B, S));
        System.out.println(solution.smallestEquivalentString("hello", "world", "hold"));
        System.out.println(solution.smallestEquivalentString("leetcode", "programs", "sourcecode"));
    }
}

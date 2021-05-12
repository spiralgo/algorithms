package algorithms.curated170.medium;

import java.util.HashMap;
import java.util.Map;

public class LexicographicallySmallestEquivalentString {

    private Map<Character, Character> parent;

    String smallestEquivalentString(String A, String B, String S) {
        parent = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            parent.put(A.charAt(i), A.charAt(i));
            parent.put(B.charAt(i), B.charAt(i));
        }
        for (int i = 0; i < A.length(); i++) {
            union(A.charAt(i), B.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < S.length(); i++) {
            sb.append(find(S.charAt(i)));
        }
        return sb.toString();
    }

    char find(char c) {
        if (c != parent.get(c)) {
            parent.put(c, find(parent.get(c)));
        }
        return parent.get(c);
    }

    void union(char a, char b) {
        char parentA = find(a);
        char parentB = find(b);
        if (parentA == parentB)
            return;

        if (parentA < parentB) {
            parent.put(parentB, parentA);
        } else {
            parent.put(parentA, parentB);
        }
    }

    public static void main(String[] args) {
        String A = "parker", B = "morris", S = "parser";
        var solution = new LexicographicallySmallestEquivalentString();
        //System.out.println(solution.smallestEquivalentString("aefgbz", "cdgbcz", S));
        System.out.println(solution.smallestEquivalentString(A, B, S));
    }
}

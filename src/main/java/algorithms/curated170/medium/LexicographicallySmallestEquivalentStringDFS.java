package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LexicographicallySmallestEquivalentStringDFS {

    private Map<Character, List<Character>> parent;

    public String smallestEquivalentString(String A, String B, String S) {
        parent = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            parent.putIfAbsent(A.charAt(i), new ArrayList<>());
            parent.putIfAbsent(B.charAt(i), new ArrayList<>());

            parent.get(A.charAt(i)).add(B.charAt(i));
            parent.get(B.charAt(i)).add(A.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder("");
        for (char c : S.toCharArray()) {
            sb.append(DFS(c,c, new HashSet<>()));
        }
        return sb.toString();
    }

    private char DFS(char c, char mn, HashSet<Character> seen)
    {
        if(seen.contains(c))
        {
            return mn;
        }
        seen.add(c);
        char res = mn;
        for(char n : parent.getOrDefault(c, Collections.emptyList())) //or List.of()  or new ArrayList<>()
        {
            if(!seen.contains(n))
            {
                res = (char) Math.min(res, DFS(n, (char) Math.min(mn, n), seen));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
        var solution = new LexicographicallySmallestEquivalentStringDFS();
        String A = "parker", B = "morris", S = "parser";
        System.out.println(solution.smallestEquivalentString(A, B, S));
        System.out.println(solution.smallestEquivalentString("hello", "world", "hold"));
        System.out.println(solution.smallestEquivalentString("leetcode", "programs", "sourcecode"));
    }
}

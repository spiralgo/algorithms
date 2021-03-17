package algorithms.curated170.medium.medium;

import java.util.HashMap;
import java.util.Map;

 
public class LexicographicallySmallestEquivalentString {
    private static Map<Character, Character> parent = new HashMap();
    
    public static void main(String[] args) {
        String a = "parker", b = "morris";
        String S = "parser";
        for (int i = 0; i < a.length(); i++) {
            parent.put(a.charAt(i), a.charAt(i));
            parent.put(b.charAt(i), b.charAt(i));
        }
        for (int i = 0; i < a.length(); i++) {
            union(a.charAt(i), b.charAt(i));
        }
        StringBuilder sb= new StringBuilder("");
        for (int i = 0; i < S.length(); i++) {
            sb.append(find(S.charAt(i)));
        }
        System.out.println(sb.toString());
    }

   static char find(char c){
        if(c == parent.get(c)){
            return c;
        }
        return find(parent.get(c));
    }
    static void union(char a, char b){
        char parentA = find(a);
        char parentB = find(b);
        if(parentA == parentB) return;
        
        if(parentA < parentB){
            parent.put(parentB, parentA);
        }else{
            parent.put(parentA, parentB);
        }
    }
}

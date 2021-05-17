package algorithms.curated170.medium.findklengthsubstringswithnorepeatedcharacters;

import java.util.HashSet;

 
public class FindKLengthSubstringsWithNoRepeatedCharacters {

public int numKLenSubstrNoRepeats(String S, int K) {
        HashSet<Character> cur = new HashSet<>();
        int res = 0, i = 0;
        for (int j = 0; j < S.length(); ++j) {
            while (cur.contains(S.charAt(j)))
                cur.remove(S.charAt(i++));
            cur.add(S.charAt(j));
            res += j - i + 1 >= K ? 1 : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        FindKLengthSubstringsWithNoRepeatedCharacters f =
                 new FindKLengthSubstringsWithNoRepeatedCharacters();
        
        int result =  f.numKLenSubstrNoRepeats("havefunonleetcode", 5);
        
        System.out.println(result);
    }
}

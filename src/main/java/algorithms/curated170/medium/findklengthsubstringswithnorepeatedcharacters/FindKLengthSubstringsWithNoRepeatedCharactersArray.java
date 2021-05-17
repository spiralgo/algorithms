package algorithms.curated170.medium.findklengthsubstringswithnorepeatedcharacters;

 
public class FindKLengthSubstringsWithNoRepeatedCharactersArray {
class Solution {
//      S = "havefunonleetcode", K = 5
         
//          s-k substrings
         
    public int numKLenSubstrNoRepeats(String S, int K) {
        int res = 0;
        boolean[] seen = new boolean[128];
        if(K>S.length()) return 0;
        int i = 0;
        int j = 0;
         char[] s = S.toCharArray();
        while (j < s.length) {
            while (seen[s[j]]) {
                seen[s[i]]=false;
                i++;
            }
            if (j-i+1>=K) res++;
            seen[s[j]]=true;
            j++;
        }
         return res;
            
        
    }
}
}

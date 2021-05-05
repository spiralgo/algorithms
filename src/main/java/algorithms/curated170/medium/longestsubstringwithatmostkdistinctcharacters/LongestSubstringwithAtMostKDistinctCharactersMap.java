package algorithms.curated170.medium.longestsubstringwithatmostkdistinctcharacters;
  
import java.util.HashMap;


public class LongestSubstringwithAtMostKDistinctCharactersMap {

    public static void main(String[] args) {
    
        LongestSubstringwithAtMostKDistinctCharactersMap lo = new LongestSubstringwithAtMostKDistinctCharactersMap();
        int output = lo.lengthOfLongestSubstringKDistinct("abbccc", 2);
        System.out.println(output);
    }

      public int lengthOfLongestSubstringKDistinct(String s, int k) {
       if(k >= s.length()) return s.length();
        HashMap<Character, Integer> counterMap = new HashMap<>();
        int left = 0;
        int currentLongest = 0;
        for(int right = 0; right<s.length(); right++){
            counterMap.merge(s.charAt(right), 1, Integer::sum);
            while(counterMap.size()>k){
                char current = s.charAt(left);
                counterMap.merge(current, -1, Integer::sum);
                if(counterMap.get(current)== 0) 
                    counterMap.remove(current);
                
                left++;
            }
            currentLongest = Math.max(currentLongest, right - left + 1);
        }

        return currentLongest;
    }
}

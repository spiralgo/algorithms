package algorithms.curated170.medium.longestsubstringwithatmosttwodistinctcharacters;

import algorithms.curated170.medium.longestsubstringwithatmostkdistinctcharacters.LongestSubstringwithAtMostKDistinctCharacters;

 
public class LongestSubstringwithAtMostTwoDistinctCharacters {
   public int lengthOfLongestSubstringTwoDistinct(String s) {
        LongestSubstringwithAtMostKDistinctCharacters withK = new LongestSubstringwithAtMostKDistinctCharacters();
        return withK.lengthOfLongestSubstringKDistinct(s, 2);
    }
}

package algorithms.curated170.medium;

 
public class LongestSubstringwithAtMostTwoDistinctCharacters {
   public int lengthOfLongestSubstringTwoDistinct(String s) {
        LongestSubstringwithAtMostKDistinctCharacters withK = new LongestSubstringwithAtMostKDistinctCharacters();
        return withK.lengthOfLongestSubstringKDistinct(s, 2);
    }
}

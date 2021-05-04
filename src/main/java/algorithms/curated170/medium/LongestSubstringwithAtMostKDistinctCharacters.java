package algorithms.curated170.medium;
  

public class LongestSubstringwithAtMostKDistinctCharacters {

    public static void main(String[] args) {
    
        LongestSubstringwithAtMostKDistinctCharacters lo = new LongestSubstringwithAtMostKDistinctCharacters();
        int output = lo.lengthOfLongestSubstringKDistinct("abbccc", 2);
        System.out.println(output);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
       if(k >= s.length()) return s.length();
      
        char[] counterMap = new char[256];
        char[] array = s.toCharArray();
        int left = 0, right = 0;
        int currentLongest = 0;
        int distinct = 0;
         
        for(int ch: array){
            if(counterMap[ch] == 0) distinct++;
            counterMap[ch]++;
            
            while(distinct>k){
                 char currShrink = array[left++];
                 if(counterMap[currShrink]==1) distinct--;
                 counterMap[currShrink]--;
                  
            }
          
           
            currentLongest = Math.max(currentLongest, right - left + 1);
            right++;
        }

        return currentLongest;
    }
}

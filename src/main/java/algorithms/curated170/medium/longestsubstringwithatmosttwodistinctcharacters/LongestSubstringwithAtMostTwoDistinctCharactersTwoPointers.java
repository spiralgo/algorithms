package algorithms.curated170.medium;

public class LongestSubstringwithAtMostTwoDistinctCharactersTwoPointers {
    
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        int aIdx = -1;
        int bIdx = -1;
        int runningLen = 0;

        char[] data = s.toCharArray();
        
        for (int i = 0; i < data.length; i++) {
            if (aIdx == -1 || data[i] == data[aIdx]) {
                aIdx = i;
                runningLen++;
                max = Math.max(max, runningLen);

            } else if (bIdx == -1 || data[i] == data[bIdx]) {
                bIdx = i;
                runningLen++;
                max = Math.max(max, runningLen);

            } else {

                if (aIdx < bIdx) {
                    runningLen = i - aIdx;
                    aIdx = i;
                } else {
                    runningLen = i - bIdx;
                    bIdx = i;
                }
            }
        }
        return max;
    }
}

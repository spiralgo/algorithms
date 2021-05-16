package algorithms.curated170.easy;

import java.util.LinkedList;
import java.util.List;

 
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        // [1, 3], lower = 0, upper = 10
        List<String> result = new LinkedList<>();
        
        
        if (nums.length == 0) {
            // lower = 1, upper = 1
            addRange(lower - 1, upper + 1, result);
            return result;
        }
        
        
        // lower = 0, [1, 3]
        if (nums[0] - lower > 0) {
            // inclusive for lower => lower - 1
            addRange(lower - 1, nums[0], result);
        }
        
        for (int i = 0; i < nums.length - 1; ++i) {
            // [3, 50], 4->49
            // [3, 5]
            // [50, 75], 51->74
            if (nums[i + 1] - nums[i] > 1) {
                addRange(nums[i], nums[i + 1], result);
            }
        }
        
        int last = nums[nums.length - 1];
        // [98], upper = 99
        if (upper - last > 0) {
            addRange(last, upper + 1, result);
        }
        
        return result;
    }
    
    // Both-side Non-inclusive range
    void addRange(int first, int second, List<String> result) {
        StringBuilder range = new StringBuilder();
        int start = first + 1;
        int end = second - 1;
        if (start == end) range.append(start);
        else {
            range.append(start);
            range.append("->");
            range.append(end);
        }
        result.add(range.toString());
    }
}

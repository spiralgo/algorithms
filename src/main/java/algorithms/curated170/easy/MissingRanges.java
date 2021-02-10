package algorithms.curated170.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 
public class MissingRanges {
 
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;

        if (n == 0) {
            return Collections.singletonList(formatRange(lower, upper));
        }

        List<String> missingRanges = new ArrayList<>();

        // Edge case 1) Missing ranges at the beginning
        if (nums[0] > lower) {
            missingRanges.add(formatRange(lower, nums[0] - 1));
        }

        // Missing ranges between array elements
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > 1) {
                missingRanges.add(formatRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }

        // Edge case 2) Missing ranges at the end
        if (nums[n - 1] < upper) {
            missingRanges.add(formatRange(nums[n - 1] + 1, upper));
        }

        return missingRanges;
    }

    // formats range in the requested format
    String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        } else {
            return lower + "->" + upper;
        }
    }
}

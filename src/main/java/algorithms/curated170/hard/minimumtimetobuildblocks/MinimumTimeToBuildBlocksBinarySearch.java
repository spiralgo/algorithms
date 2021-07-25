package algorithms.curated170.hard;

import java.util.Arrays;

public class MinimumTimeToBuildBlocksBinarySearch {

    public int minBuildTime(int[] blocks, int split) {
        // A worker can either split into two workers or build a block and go home
        int n = blocks.length;
        Arrays.sort(blocks);
        int maxVal = blocks[n - 1];
        // Binary search the maximum time in the obvious range of [max, 10*split +
        // maxv].
        int lo = maxVal;
        int hi = split * 10 + maxVal;
        int ans = hi;
        while (lo < hi) {
            int target = (lo + hi) / 2;
            if (isOk(target, blocks, split)) {
                ans = Math.min(ans, target);
                hi = target;
            } else {
                lo = target + 1;
            }
        }

        return ans;
    }

    // Check whether all blocks can be built in time t.
    private boolean isOk(int t, int[] blocks, int split) {
        // current level and corresponding number of workers
        int level = 0;
        int worker = 1;
        for (int i = blocks.length - 1; i >= 0; i--) {
            // maximal number of split before the worker build the block
            // value of k is non-descending when i increase.
            int k = (t - blocks[i]) / split;
            while (level < k) {
                worker *= 2;
                level++;
                // avoid overflow
                if (worker > i) {
                    return true;
                }
            }
            if (--worker < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new MinimumTimeToBuildBlocksBinarySearch();
        int[] blocks = new int[]{2,3,4,5};
        
        System.out.println(solution.minBuildTime(blocks, 3));
    }
}

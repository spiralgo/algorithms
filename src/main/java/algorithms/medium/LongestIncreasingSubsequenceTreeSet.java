package algorithms.medium;

import java.util.TreeSet;
// Refer to: https://github.com/altayhunoglu/algorithms/issues/101
public class LongestIncreasingSubsequenceTreeSet {

    public int lengthOfLIS(int[] ar) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < ar.length; i++) {
            Integer ceil = set.ceiling(ar[i]);
            if (ceil != null) {
                set.remove(ceil);
            }
            set.add(ar[i]);
        }
        return set.size();
    }
}

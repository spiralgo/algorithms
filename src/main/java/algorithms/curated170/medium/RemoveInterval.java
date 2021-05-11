package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RemoveInterval {

    public int[][] removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<int[]> intervals_ = new ArrayList<>();
        int start = toBeRemoved[0], end = toBeRemoved[1];
        for (int[] interval : intervals) {
            
            if (interval[1] <= start || interval[0] >= end) {
                intervals_.add(interval);
                continue;
            }
            
            if (interval[0] < start) {
                intervals_.add(new int[]{interval[0], start})
            }
            if (interval[1] > end) {
                intervals_.add(new int[]{end, interval[1]})
            }

        }
        return (int[][]) intervals_.toArray();
    }

    public static void main(String[] args) {

    }
}

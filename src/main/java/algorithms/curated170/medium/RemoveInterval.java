package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RemoveInterval {

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> updatedIntervals = new ArrayList<>();
        int start = toBeRemoved[0], end = toBeRemoved[1];
        for (int[] interval : intervals) {
            
            if (interval[1] <= start || interval[0] >= end) {
                updatedIntervals.add(List.of(interval[0], interval[1]));
                continue;
            }
            
            if (interval[0] < start) {
                updatedIntervals.add(List.of(interval[0], start));
            }
            if (interval[1] > end) {
                updatedIntervals.add(List.of(end, interval[1]));
            }

        }
        return updatedIntervals;
    }

    public static void main(String[] args) {

    }
}

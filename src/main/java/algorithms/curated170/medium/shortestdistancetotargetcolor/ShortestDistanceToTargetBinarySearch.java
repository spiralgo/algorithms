package algorithms.curated170.medium.shortestdistancetotargetcolor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestDistanceToTargetBinarySearch {

    private List<List<Integer>> look;

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        look = List.of(Collections.emptyList(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            look.get(color).add(i);
        }
        
        List<Integer> ret = new ArrayList<>();

        final boolean[] hasColor = new boolean[] { false, !look.get(1).isEmpty(), !look.get(2).isEmpty(),
                !look.get(3).isEmpty() };

        for (int[] query : queries) {
            int idx = query[0];
            int c = query[1];
            if (hasColor[c])
                ret.add(Math.abs(idx - binarySearch(idx, look.get(c))));
            else
                ret.add(-1);
        }
        return ret;
    }

    private int binarySearch(int value, List<Integer> list) {
        if (value < list.get(0)) {
            return list.get(0);
        }
        if (value > list.get(list.size() - 1)) {
            return list.get(list.size() - 1);
        }

        int lo = 0;
        int hi = list.size() - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (value < list.get(mid)) {
                hi = mid - 1;
            } else if (value > list.get(mid)) {
                lo = mid + 1;
            } else {
                return list.get(mid);
            }
        }
        
        return (list.get(lo) - value) < (value - list.get(hi)) ? list.get(lo) : list.get(hi);
    }

    public static void main(String[] args) {
        var solution = new ShortestDistanceToTargetBinarySearch();

        int[] colors = new int[] { 1, 1, 2, 1, 3, 2, 2, 3, 3 };
        int[][] queries = new int[][] { { 1, 3 }, { 2, 2 }, { 6, 1 } };
        solution.shortestDistanceColor(colors, queries);

    }
}
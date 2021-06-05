package algorithms.curated170.medium.shortestdistancetotargetcolor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestDistanceToTargetBinarySearch {

    private List<List<Integer>> colorIndices;

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {

        setColorIndices(colors);

        return handleQueriesLookup(queries);
    }

    private void setColorIndices(int[] colors) {
        colorIndices = List.of(Collections.emptyList(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            colorIndices.get(color).add(i);
        }
    }

    private List<Integer> handleQueriesLookup(int[][] queries) {

        List<Integer> distList = new ArrayList<>();

        final boolean[] hasColor = new boolean[] { false, !colorIndices.get(1).isEmpty(),
                !colorIndices.get(2).isEmpty(), !colorIndices.get(3).isEmpty() };

        for (int[] query : queries) {
            int idx = query[0];
            int color = query[1];

            if (hasColor[color]) {
                distList.add(getClosestDist(idx, color));
            } else {
                distList.add(-1);
            }
        }
        return distList;
    }

    private int getClosestDist(int idx, int color) {
        int closestIdx = binarySearchIndices(idx, colorIndices.get(color));
        return Math.abs(idx - closestIdx);
    }

    private int binarySearchIndices(int idx, List<Integer> colorList) {
        if (idx < colorList.get(0)) {
            return colorList.get(0);
        }
        if (idx > colorList.get(colorList.size() - 1)) {
            return colorList.get(colorList.size() - 1);
        }

        int lo = 0;
        int hi = colorList.size() - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (idx < colorList.get(mid)) {
                hi = mid - 1;
            } else if (idx > colorList.get(mid)) {
                lo = mid + 1;
            } else {
                return colorList.get(mid);
            }
        }

        return (colorList.get(lo) - idx) < (idx - colorList.get(hi)) ? colorList.get(lo) : colorList.get(hi);
    }

    public static void main(String[] args) {
        var solution = new ShortestDistanceToTargetBinarySearch();

        int[] colors = new int[] { 1, 1, 2, 1, 3, 2, 2, 3, 3 };
        int[][] queries = new int[][] { { 1, 3 }, { 2, 2 }, { 6, 1 } };
        System.out.println(solution.shortestDistanceColor(colors, queries)); // prints [3, 0, 3]

    }
}
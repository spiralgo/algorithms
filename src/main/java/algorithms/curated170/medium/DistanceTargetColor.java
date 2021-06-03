package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistanceTargetColor {

    private static final int NOT_FOUND = Integer.MAX_VALUE;
    int[][] closestDistTable;

    public List<Integer> sDC(int[] colors, int[][] queries) {

        closestDistTable = new int[colors.length][];
        int[] nearest = new int[4];
        Arrays.fill(nearest, NOT_FOUND);

        assignClosestLeftColors(colors, nearest);

        compareClosestRightColors(colors);

        return assignClosestDistances(queries);
    }

    private List<Integer> assignClosestDistances(int[][] queries) {

        List<Integer> distList = new ArrayList<>();

        for (int[] query : queries) {
            int dist = closestDistTable[query[0]][query[1]];

            if (dist == NOT_FOUND) {
                dist = -1;
            }

            distList.add(dist);
        }

        return distList;
    }

    private void compareClosestRightColors(int[] colors) {
        for (int i = colors.length - 2; i >= 0; i--) {
            for (int c = 1; c <= 3; c++) {
                closestDistTable[i][c] = Math.min(closestDistTable[i][c], closestDistTable[i + 1][c] + 1);
            }
        }
    }

    private void assignClosestLeftColors(int[] colors, int[] nearest) {
        for (int i = 0; i < colors.length; i++) {
            nearest[colors[i]] = 0;

            for (int j = 1; j <= 3; j++) {
                if (nearest[j] != NOT_FOUND && j != colors[i]) {
                    nearest[j]++;
                }
            }

            closestDistTable[i] = nearest.clone();
        }
    }

    private List<List<Integer>> look;

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        look = List.of(Collections.emptyList(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            look.get(color).add(i);
        }
        System.out.println(look);
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
        System.out.println(ret);
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
        // lo == hi + 1
        return (list.get(lo) - value) < (value - list.get(hi)) ? list.get(lo) : list.get(hi);
    }

    public static void main(String[] args) {
        var solution = new DistanceTargetColor();

        int[] colors = new int[] { 1, 1, 2, 1, 3, 2, 2, 3, 3 };
        int[][] queries = new int[][] { { 1, 3 }, { 2, 2 }, { 6, 1 } };
        System.out.println(solution.sDC(colors, queries));
        solution.shortestDistanceColor(colors, queries);

    }
}
package algorithms.curated170.medium.shortestdistancetotargetcolor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToTargetColorPreprocessing {

    private static final int NOT_FOUND = Integer.MAX_VALUE;
    private int[][] leftClosestIndices;
    private int[][] rightClosestIndices;

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {

        assignClosestLeftColors(colors);

        compareClosestRightColors(colors);

        return handleQueriesLookup(queries);
    }

    private void assignClosestLeftColors(int[] colors) {
        leftClosestIndices = new int[colors.length][4];
        int[] nearest = new int[4];
        Arrays.fill(nearest, NOT_FOUND);

        for (int i = 0; i < colors.length; i++) {
            nearest[colors[i]] = i;

            for (int c = 0; c <= 3; c++) {
                leftClosestIndices[i][c] = nearest[c];
            }
        }
    }

    private void compareClosestRightColors(int[] colors) {
        rightClosestIndices = new int[colors.length][4];
        int[] nearest = new int[4];
        Arrays.fill(nearest, NOT_FOUND);

        for (int i = colors.length - 1; i >= 0; i--) {
            nearest[colors[i]] = i;
            for (int c = 1; c <= 3; c++) {
                rightClosestIndices[i][c] = nearest[c];
            }
        }
    }

    private List<Integer> handleQueriesLookup(int[][] queries) {

        List<Integer> distList = new ArrayList<>();

        for (int[] query : queries) {
            int idx = query[0];
            int color = query[1];

            int leftBest = leftClosestIndices[idx][color];
            int rightBest = rightClosestIndices[idx][color];

            int dist = NOT_FOUND;
            if(leftBest!=NOT_FOUND)
            {
                dist = idx - leftBest;
            }
            if(rightBest != NOT_FOUND)
            {
                dist = Math.min(dist, rightBest - idx);
            }

            distList.add(dist == NOT_FOUND ? -1 : dist);
        }

        return distList;
    }

    public static void main(String[] args) {
        var solution = new ShortestDistanceToTargetColorPreprocessing();

        int[] colors = new int[] { 1, 1, 2, 1, 3, 2, 2, 3, 3 };
        int[][] queries = new int[][] { { 1, 3 }, { 2, 2 }, { 6, 1 } };
        System.out.println(solution.shortestDistanceColor(colors, queries)); // prints [3, 0, 3]
        colors = new int[] { 1, 2 };
        queries = new int[][] { { 0, 3 } };
        System.out.println(solution.shortestDistanceColor(colors, queries)); // prints [-1]

    }
}
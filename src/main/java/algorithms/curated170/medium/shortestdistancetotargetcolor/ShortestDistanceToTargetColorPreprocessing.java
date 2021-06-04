package algorithms.curated170.medium.shortestdistancetotargetcolor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToTargetColorPreprocessing {

    private static final int NOT_FOUND = Integer.MAX_VALUE;
    private int[][] closestDistTable;

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {

        assignClosestLeftColors(colors);

        compareClosestRightColors(colors);

        return handleQueriesLookup(queries);
    }

    private void assignClosestLeftColors(int[] colors) {
        closestDistTable = new int[colors.length][];
        int[] nearest = new int[4];
        Arrays.fill(nearest, NOT_FOUND);

        for (int i = 0; i < colors.length; i++) {
            nearest[colors[i]] = 0;

            for (int c = 1; c <= 3; c++) {
                if (nearest[c] != NOT_FOUND && c != colors[i]) {
                    nearest[c]++;
                }
            }

            closestDistTable[i] = nearest.clone();
        }
    }

    private void compareClosestRightColors(int[] colors) {
        for (int i = colors.length - 2; i >= 0; i--) {
            for (int c = 1; c <= 3; c++) {
                closestDistTable[i][c] = Math.min(closestDistTable[i][c], closestDistTable[i + 1][c] + 1);
            }
        }
    }

    private List<Integer> handleQueriesLookup(int[][] queries) {

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

    public static void main(String[] args) {
        var solution = new ShortestDistanceToTargetColorPreprocessing();

        int[] colors = new int[] { 1, 1, 2, 1, 3, 2, 2, 3, 3 };
        int[][] queries = new int[][] { { 1, 3 }, { 2, 2 }, { 6, 1 } };
        System.out.println(solution.shortestDistanceColor(colors, queries)); // prints [3, 0, 3]

    }
}
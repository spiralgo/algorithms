package algorithms.curated170.medium.shortestdistancetotargetcolor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToTargetColorPreprocessing {

    private static final int NOT_FOUND = Integer.MAX_VALUE;
    int[][] closestDistTable;

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {

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
    public static void main(String[] args) {
        var solution = new ShortestDistanceToTargetColorPreprocessing();

        int[] colors = new int[] { 1, 1, 2, 1, 3, 2, 2, 3, 3 };
        int[][] queries = new int[][] { { 1, 3 }, { 2, 2 }, { 6, 1 } };
        solution.shortestDistanceColor(colors, queries);

    }
}
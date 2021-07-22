package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.List;

public class TheMostSimilarPathInAGraph {

    int n;
    boolean[][] isAdjacent;
    String[] names;
    String[] targetPath;
    int targetLength;
    int[][] distancesAtCities;

    private void calculateDistancesBackwards() {
        String targetCity;
        for (int t = targetLength - 2; t >= 0; t--) {
            targetCity = targetPath[t];
            for (int c = 0; c < n; c++) {
                String curCity = names[c];
                if (!curCity.equals(targetCity))
                    distancesAtCities[t][c] = 1;
                int minNextValue = Integer.MAX_VALUE;
                for (int nextCity = 0; nextCity < n; nextCity++) {
                    if (isAdjacent[nextCity][c] == true)
                        minNextValue = Math.min(distancesAtCities[t + 1][nextCity], minNextValue);
                }
                distancesAtCities[t][c] += minNextValue;
            }
        }
    }

    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {

        this.n = n;
        this.names = names;
        this.targetPath = targetPath;
        isAdjacent = new boolean[n][n];

        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            isAdjacent[x][y] = isAdjacent[y][x] = true;
        }

        targetLength = targetPath.length;
        distancesAtCities = new int[targetLength][n];

        setLastDistances();

        calculateDistancesBackwards();

        return evaluateMostSimilarPath();
    }

    private List<Integer> evaluateMostSimilarPath() {
        List<Integer> mostSimilarPath = new ArrayList<>(targetLength);
        int prevCity = 0;

        for (int i = 1; i < n; i++) {
            if (distancesAtCities[0][i] < distancesAtCities[0][prevCity]) {
                prevCity = i;
            }
        }
        mostSimilarPath.add(prevCity);

        addNextVertices(mostSimilarPath, prevCity, 1);

        return mostSimilarPath;
    }

    private void addNextVertices(List<Integer> mostSimilarPath, int prevCity, int idx) {

        if (idx == targetLength) {
            return;
        }

        int curMinCity = -1;
        int curMinDist = Integer.MAX_VALUE;

        for (int nextCity = 0; nextCity < n; nextCity++) {
            if (isAdjacent[nextCity][prevCity] == false) {
                continue;
            }

            if (distancesAtCities[idx][nextCity] < curMinDist) {
                curMinDist = distancesAtCities[idx][nextCity];
                curMinCity = nextCity;
            }
        }

        mostSimilarPath.add(curMinCity);
        addNextVertices(mostSimilarPath, curMinCity, idx + 1);
    }

    private void setLastDistances() {
        String targetCity = targetPath[targetLength - 1];
        for (int i = 0; i < n; i++) {
            String curCity = names[i];
            if (!targetCity.equals(curCity)) {
                distancesAtCities[targetLength - 1][i] = 1;
            }
        }
    }

}

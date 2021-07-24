package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.List;

public class TheMostSimilarPathInAGraphDP {
    
    int n;
    String[] names;
    String[] targetPath;
    int targetLength;
    int[][] distancesAtCities;
    int[][] graph;
 
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
 
        this.n = n;
        this.names = names;
        this.targetPath = targetPath;
        graph = createGraph(n, roads);
       
 
        targetLength = targetPath.length;
        distancesAtCities = new int[targetLength][n];
 
        setLastDistances();
 
        calculateDistancesBackwards();
 
        return evaluateMostSimilarPath();
    }
 private int[][] createGraph(int n, int[][] roads) {
        int[][] graph = new int[n][];
 
        int[] adjacentCount = new int[n];
        for (int[] road : roads) {
            adjacentCount[road[0]]++;
            adjacentCount[road[1]]++;
        }
 
        for (int i = 0; i < n; i++) {
            graph[i] = new int[adjacentCount[i]];
        }
        int[] currIdx = new int[n];
        for (int[] road : roads) {
            graph[road[0]][currIdx[road[0]]++] = road[1];
            graph[road[1]][currIdx[road[1]]++] = road[0];
        }
        return graph;
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
 
    private void calculateDistancesBackwards() {
        String targetCity;
 
        for (int t = targetLength - 2; t >= 0; t--) {
            targetCity = targetPath[t];
 
            for (int c = 0; c < n; c++) {
                String curCity = names[c];
 
                if (!curCity.equals(targetCity)) {
                    distancesAtCities[t][c] = 1;
                }
             
                int minNextValue = Integer.MAX_VALUE;
             
                for (int nextCity : graph[c]) {
                    
                        minNextValue = Math.min(distancesAtCities[t + 1][nextCity], minNextValue);
                    
                }
 
                distancesAtCities[t][c] += minNextValue;
            }
        }
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
 
          for (int nextCity : graph[prevCity]) {
 
            if (distancesAtCities[idx][nextCity] < curMinDist) {
                curMinDist = distancesAtCities[idx][nextCity];
                curMinCity = nextCity;
            }
        }
 
        mostSimilarPath.add(curMinCity);
        addNextVertices(mostSimilarPath, curMinCity, idx + 1);
    }
 
}
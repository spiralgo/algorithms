package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.List;

public class TheMostSimilarPathInAGraph {

    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {

        // Start with creating a graph based on the given roads. Mark 1 for each road
        // pairs.
        int[][] graph = new int[n][n];
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            graph[x][y] = graph[y][x] = 1;
        }
        // With this graph in mind, now let's look at the actual problem - we need to
        // come up with a path that has least edit distance in comparison to the
        // targetPath. So, if we know the minimum possible edit distance till a given
        // index of the targetPath (say i), we will be able to compute the minimum
        // possible edit distance till (i+1). The only catch here is that we have to
        // check which nodes from ith column, can be used to calculate (i+1)th column
        // for a given cell. We could find this from our initial graph.

        int targetLength = targetPath.length;
        int[][] distancesAtCities = new int[targetLength][n];
        String targetCity = targetPath[targetLength - 1];
        for (int i = 0; i < n; i++) {
            String curCity = names[i];
            if (!targetCity.equals(curCity))
                distancesAtCities[targetLength - 1][i] = 1;
        }
        // The perspective is shifted from graph traversal to a DP optimization.

        for (int t = targetLength - 2; t >= 0; t--) {
            targetCity = targetPath[t];
            for (int c = 0; c < n; c++) {
                String curCity = names[c];
                if (!curCity.equals(targetCity))
                    distancesAtCities[t][c] = 1;
                int minNextValue = Integer.MAX_VALUE;
                for (int nextCity = 0; nextCity < n; nextCity++) {
                    if (graph[nextCity][c] == 1)
                        minNextValue = Math.min(distancesAtCities[t + 1][nextCity], minNextValue);
                }
                distancesAtCities[t][c] += minNextValue;
            }
        }
        /*
         * Once we computed the DP matrix bottom, we have to build our solution top
         * down. Once again we traverse our DP matrix starting with row 0 and find the
         * index which gives us the minimum edit distance. We store it in prevInd
         * variable. From there, we find out the node which is connected to the previous
         * node and has the minimum edit distance. We add this to our output. Update our
         * prevInd to the current minimum index (curMinInd). Keep repeating step 7 till
         * we reach the end of the target path.
         */

        List<Integer> mostSimilarPath = new ArrayList<>(targetLength);
        int prevCity = 0;

        for (int i = 1; i < n; i++) {
            if (distancesAtCities[0][i] < distancesAtCities[0][prevCity]) {
                prevCity = i;
            }
        }
        mostSimilarPath.add(prevCity);

        for (int i = 1; i < targetLength; i++) {
            int curMinIdx = -1;
            int curMinDist = Integer.MAX_VALUE;

            for (int nextCity = 0; nextCity < n; nextCity++) {
                if (graph[nextCity][prevCity] != 1) {
                    continue;
                }

                if (distancesAtCities[i][nextCity] < curMinDist) {
                    curMinDist = distancesAtCities[i][nextCity];
                    curMinIdx = nextCity;
                }
            }

            mostSimilarPath.add(curMinIdx);
            prevCity = curMinIdx;
        }

        return mostSimilarPath;
    }

}

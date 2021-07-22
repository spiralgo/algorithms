package algorithms.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStopsBFS {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // convert flights[] to a weighted graph
        // perform BFS starting from src going only max depth of K
        // For Each node track the cost associated to reach that node
        int[][] graph = createAdjacencyMatrix(n, flights);
        
        return bfsForKLayers(n, src, dst, K, graph);
    }

    private int bfsForKLayers(int n, int src, int dst, int layersLeft, int[][] graph) {
        int min = Integer.MAX_VALUE;
        int[] minDist = new int[n];
        Deque<int[]> vertexDistPairs = new ArrayDeque<>();
        
        vertexDistPairs.add(new int[]{src,0});
        while (!vertexDistPairs.isEmpty() && layersLeft >= 0) {
            layersLeft--;
            int layerSize = vertexDistPairs.size();

            for (int i = 0; i < layerSize; i++) {
                int[] vertexAndCost = vertexDistPairs.poll();
                int pre = vertexAndCost[0];
                int currCost = vertexAndCost[1];

                for (int nextVertex = 0; nextVertex < n; nextVertex++) {
                    int edgeWeight = graph[pre][nextVertex];
                    if (edgeWeight > 0) { 
                        min = compareWithPreviousDistance(dst, min, minDist, vertexDistPairs, currCost, nextVertex, edgeWeight);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int compareWithPreviousDistance(int dst, int min, int[] minDist, Deque<int[]> vertexDistPairs, int currCost, int nextVertex, int edgeWeight) {
        int altDist = currCost + edgeWeight;
        int oldDist = minDist[nextVertex];
        
        if (oldDist == 0 || oldDist > altDist) {
            minDist[nextVertex] = altDist;
            vertexDistPairs.add(new int[]{nextVertex,altDist});
            if (nextVertex == dst && min > altDist) {
                min = altDist;
            }
        }
        return min;
    }

    private int[][] createAdjacencyMatrix(int n, int[][] flights) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            graph[start][end] = flight[2];
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][] flights = { { 0, 1, 200 }, { 0, 2, 500 }, { 1, 2, 250 } };
        var solution = new CheapestFlightsWithinKStopsBFS();
        System.out.println(solution.findCheapestPrice(3, flights, 0, 2, 0));

        flights = new int[][] { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
        System.out.println(solution.findCheapestPrice(4, flights, 0, 3, 1));
    }
}

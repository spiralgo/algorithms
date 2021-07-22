package algorithms.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStopsDFS {

    private HashMap<List<Integer>, Integer> memo;
    final static int INF = Integer.MAX_VALUE >> 4;
    int globalMin;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        memo = new HashMap<>();
        globalMin = INF;
        int[][][] graph = createGraph(flights, n);

        
        int shortestDist = dfs(graph, src, dst, K + 1, 0);
        return shortestDist >= INF ? -1 : shortestDist;
    }

    int[][][] createGraph(int[][] arcs, int n) {
        int[][][] graph = new int[n][][];

        int[] outDegree = new int[n + 1];
        for (int[] arc : arcs) {
            outDegree[arc[0]]++;
        }

        for (int i = 0; i < n; i++) {
            graph[i] = new int[outDegree[i]][2];
        }
        int[] currIdx = new int[n];
        for (int[] arc : arcs) {
            graph[arc[0]][currIdx[arc[0]]][0] = arc[1];
            graph[arc[0]][currIdx[arc[0]]++][1] = arc[2];
        }
        return graph;
    }

    public int dfs(int[][][] graph, int src, int dst, int k, int cost) {
        if (k < 0)
            return INF;
        if (src == dst) {
            globalMin = Math.min(globalMin, cost);
            return 0;
        }
        if (cost > globalMin) {
            return INF;
        }
        if (memo.containsKey(List.of(src, k))) {
            return memo.get(List.of(src, k));
        }

        int shortestDist = INF;
        for (int[] i : graph[src]) {
            shortestDist = Math.min(shortestDist, i[1] + dfs(graph, i[0], dst, k - 1, cost + i[1]));
        }
        memo.put(List.of(src, k), shortestDist);
        return shortestDist;
    }

    public static void main(String[] args) {
        int[][] flights = { { 0, 1, 200 }, { 0, 2, 500 }, { 1, 2, 250 } };
        var solution = new CheapestFlightsWithinKStopsDFS();
        System.out.println(solution.findCheapestPrice(3, flights, 0, 2, 0));

        flights = new int[][] { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
        System.out.println(solution.findCheapestPrice(4, flights, 0, 3, 1));
    }
}

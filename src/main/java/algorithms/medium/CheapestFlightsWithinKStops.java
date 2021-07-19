package algorithms.medium;

import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, final int K) {
        int[][][] graph = createGraph(flights, n);
        return dijkstra(graph, src, dst, K, n);
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

    int dijkstra(int[][][] graph, int src, int dst, final int K, int n) {
        int[] dist = new int[n];
        int[] currStops = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        initializeDijkstra(src, n, dist, currStops, pq);

        while (!pq.isEmpty()) {
            int[] pathInfo = pq.poll();
            int vertex = pathInfo[0];
            int cost = pathInfo[1];
            int stops = pathInfo[2];

            if (vertex == dst) {
                return cost;
            }
            if (stops == K + 1) {
                continue;
            }

            for (int[] arc : graph[vertex]) {
                int nextVertex = arc[0];
                int altDist = cost + arc[1];

                if (altDist < dist[nextVertex]) {
                    pq.offer(new int[] { nextVertex, altDist, stops + 1 });
                    dist[nextVertex] = altDist;
                } else if (stops < currStops[nextVertex]) {
                    pq.offer(new int[] { nextVertex, altDist, stops + 1 });
                }
                currStops[nextVertex] = stops;
            }
        }
        return -1;
    }

    private void initializeDijkstra(int src, int n, int[] dist, int[] steps, PriorityQueue<int[]> pq) {
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            steps[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        steps[src] = 0;
        pq.offer(new int[] { src, 0, 0 });
    }

    public static void main(String[] args) {
        int[][] flights = { { 0, 1, 200 }, { 0, 2, 500 }, { 1, 2, 250 } };
        var solution = new CheapestFlightsWithinKStops();
        System.out.println(solution.findCheapestPrice(3, flights, 0, 2, 0));

        flights = new int[][] { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
        System.out.println(solution.findCheapestPrice(4, flights, 0, 3, 1));
    }
}

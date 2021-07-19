package algorithms.medium;

import java.util.Arrays;

public class CheapestFlightsWithinKStopsBellmanFord {
    final static int INF = Integer.MAX_VALUE >> 3;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst,final int K) {
        int[][] dist = new int[2][n];
        
        Arrays.fill(dist[0], INF);
        Arrays.fill(dist[1], INF);
        dist[0][src] = dist[1][src] = 0;
        
        for (int i = 0; i < K + 1; i++) {
            for (int[] edge : flights) {
                int pre = edge[0], next = edge[1], cost = edge[2];
                int altDist = dist[~i&1][pre] + cost;

                if (altDist < dist[i&1][next]) {
                    dist[i&1][next] = altDist;
                }
            }
        }
        
        return dist[K&1][dst] < INF ? dist[K&1][dst] : -1;
    }

    public static void main(String[] args) {
        int[][] flights = { { 0, 1, 200 }, { 0, 2, 500 }, { 1, 2, 250 } };
        var solution = new CheapestFlightsWithinKStopsBellmanFord();
        System.out.println(solution.findCheapestPrice(3, flights, 0, 2, 0));
        System.out.println(solution.findCheapestPrice(3, flights, 0, 2, 1));

        flights = new int[][] { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
        System.out.println(solution.findCheapestPrice(4, flights, 0, 3, 1));
        System.out.println(solution.findCheapestPrice(4, flights, 0, 3, 3));
    }
}

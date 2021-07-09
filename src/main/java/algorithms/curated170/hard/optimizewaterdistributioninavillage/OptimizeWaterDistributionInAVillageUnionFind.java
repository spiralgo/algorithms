package algorithms.curated170.hard.optimizewaterdistributioninavillage;

import java.util.Arrays;
import java.util.PriorityQueue;

public class OptimizeWaterDistributionInAVillageUnionFind {

    int[] parent;
    int[] rank;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        rank[0] = 1;

        PriorityQueue<int[]> pq = createEdgesHeap(n, wells, pipes);

        return getConnectionCost(n, pq);
    }

    private PriorityQueue<int[]> createEdgesHeap(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { 0, i + 1, wells[i] });
            parent[i + 1] = i + 1;
            rank[i + 1] = 1;
        }
        for (int[] pipe : pipes) {
            pq.offer(pipe);
        }
        return pq;
    }

    private int getConnectionCost(int n, PriorityQueue<int[]> pq) {
        int costs = 0;
        int unconnected = n + 1;

        while (unconnected > 1) {
            int[] edge = pq.poll();
            int a = edge[0], b = edge[1];
            int parA = find(a), parB = find(b);

            if (parA == parB) {
                continue;
            }

            if (rank[parA] <= rank[parB]) {
                parent[parA] = parB;
                rank[parB] += rank[parA];
            } else {
                parent[parB] = parA;
                rank[parA] += rank[parB];
            }
            unconnected--;
            costs += edge[2];
        }
        return costs;
    }

    int find(int k) {
        if (k != parent[k]) {
            parent[k] = find(parent[k]);
        }
        return parent[k];
    }

    public static void main(String[] args) {
        var solution = new OptimizeWaterDistributionInAVillageUnionFind();

        int[] wells = new int[] { 1, 2, 2 };
        int[][] pipes = new int[][] { { 1, 2, 1 }, { 2, 3, 1 } };
        System.out.println(solution.minCostToSupplyWater(3, wells, pipes));
    }
}

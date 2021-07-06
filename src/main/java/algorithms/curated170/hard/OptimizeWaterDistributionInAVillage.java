package algorithms.curated170.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class OptimizeWaterDistributionInAVillage {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { 0, i + 1, wells[i] });
            parent[i + 1] = i + 1;
        }
        for (int[] pipe : pipes) {
            pq.offer(pipe);
        }

        int com = n + 1;
        int costs = 0;
        while (com > 1) {
            int[] edge = pq.poll();
            int a = edge[0], b = edge[1];
            int parA = find(a), parB = find(b);
            if(parA == parB)
            {
                continue;
            }
            parent[parB] = parA;
            com--;
            costs += edge[2];
        }
        return costs;
    }

    int[] parent;

    int find(int k) {
        if (k != parent[k]) {
            parent[k] = find(parent[k]);
        }
        return parent[k];
    }
    public static void main(String[] args) {
        var solution = new OptimizeWaterDistributionInAVillage();

        int[] wells = new int[]{1,2,2};
        int[][] pipes = new int[][]{
            {1,2,1},
            {2,3,1}
        };
        System.out.println(solution.minCostToSupplyWater(3, wells, pipes));
    }
}

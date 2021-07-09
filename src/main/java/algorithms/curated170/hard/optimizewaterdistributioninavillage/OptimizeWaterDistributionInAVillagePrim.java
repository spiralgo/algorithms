package algorithms.curated170.hard.optimizewaterdistributioninavillage;

import java.util.PriorityQueue;

public class OptimizeWaterDistributionInAVillagePrim {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

        int[][][] graph = createGraph(n, wells, pipes);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] edge : graph[0]) {
            pq.offer(edge);
        }

        return getCostsMST(n, graph, pq);
    }

    private int getCostsMST(int n, int[][][] graph, PriorityQueue<int[]> pq) {
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        int visitCount = 0;
        int costs = 0;

        while (visitCount < n) {
            int[] edge = pq.poll();
            
            if (visited[edge[0]]) {
                continue;
            }

            visited[edge[0]] = true;
            visitCount++;
            costs += edge[1];

            for (int[] newEdge : graph[edge[0]]) {
                if (visited[newEdge[0]]) {
                    continue;
                }
                pq.offer(newEdge);
            }
        }

        return costs;
    }

    private int[][][] createGraph(int n, int[] wells, int[][] edges) {
        int[][][] graph = new int[n + 1][][];
        
        graph[0] = new int[n][2];
        for (int i = 0; i < n; i++) {
            graph[0][i][0] = i + 1;
            graph[0][i][1] = wells[i];
        }

        int[] adjacentCount = new int[n + 1];
        for (int[] edge : edges) {
            adjacentCount[edge[0]]++;
            adjacentCount[edge[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            graph[i] = new int[adjacentCount[i]][2];
        }
        int[] currIdx = new int[n + 1];
        for (int[] edge : edges) {
            graph[edge[0]][currIdx[edge[0]]][0] = edge[1];
            graph[edge[1]][currIdx[edge[1]]][0] = edge[0];
            graph[edge[0]][currIdx[edge[0]]++][1] = edge[2];
            graph[edge[1]][currIdx[edge[1]]++][1] = edge[2];
        }
        return graph;
    }

    public static void main(String[] args) {
        var solution = new OptimizeWaterDistributionInAVillagePrim();

        int[] wells = new int[] { 1, 2, 2 };
        int[][] pipes = new int[][] { { 1, 2, 1 }, { 2, 3, 1 } };
        System.out.println(solution.minCostToSupplyWater(3, wells, pipes));
        // The Graph: [[[1, 1], [2, 2], [3, 2]], [[2, 1]], [[1, 1], [3, 1]], [[2, 1]]]
    }
}

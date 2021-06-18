package algorithms.curated170.medium;

public class GraphValidTreeDFS {

    int[][] graph;
    boolean[] visited;
    int nodeCount = 0;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        visited = new boolean[n];
        createGraph(n, edges);
        return isValidTreeNode(0, -1) && nodeCount == n;
    }

    private boolean createGraph(int n, int[][] edges) {
        int[] adjacentCount = new int[n];
        for (int[] edge : edges) {
            adjacentCount[edge[0]]++;
            adjacentCount[edge[1]]++;
        }
        graph = new int[n][];
        for (int i = 0; i < n; i++) {
            graph[i] = new int[adjacentCount[i]];
        }
        int[] currIdx = new int[n];
        for (int[] edge : edges) {
            graph[edge[0]][currIdx[edge[0]]++] = edge[1];
            graph[edge[1]][currIdx[edge[1]]++] = edge[0];
        }
        return true;
    }

    private boolean isValidTreeNode(int root, int parent) {
        nodeCount++;
        visited[root] = true;
        for (int child : graph[root]) {
            if (child != parent) {
                if (visited[child] || !isValidTreeNode(child, root)) {
                    return false;
                }
            }
        }
        return true;
    }
}
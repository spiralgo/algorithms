package algorithms.curated170.medium;

import java.util.Arrays;

 
public class ConnectingCitiesWithMinimumCost {
   public int minimumCost(int N, int[][] connections) {
        DisjointSet disjointset = new DisjointSet(N);
        // Sort connections based on their weights (in increasing order)
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        // Keep track of total edges added in the MST
        int total = 0;
        // Keep track of the total cost of adding all those edges
        int cost = 0;
        for (int i = 0; i < connections.length; ++i) {
            int a = connections[i][0];
            int b = connections[i][1];
            // Do not add the edge from a to b if it is already connected
            if (disjointset.isInSameGroup(a, b)) continue;
            // If a and b are not connected, take union
            disjointset.union(a, b);
            // increment cost
            cost += connections[i][2];
            // increment number of edges added in the MST
            total++;
        }
        // If all N nodes are connected, the MST will have a total of N - 1 edges
        if (total == N - 1) {
            return cost;
        } else {
            return -1;
        }
    }
}
 

class DisjointSet {
    private int[] rank; // Used to store weights of each nodes 
    private int[] parent;

 // Perform Union of two subsets
    public void union(int a, int b)
    {
        // find the root of the sets in which elements
        // `x` and `y` belongs
        int x = find(a);
        int y = find(b);
 
        // if `x` and `y` are present in the same set
        if (x == y) {
            return;
        }
 
        // Always attach a smaller depth tree under the
        // root of the deeper tree.
        if (rank[x] > rank[y]) {
            parent[y] = x;
        }
        else if (rank[x] < rank[y]) {
            parent[x] = y;
        }
        else {
            parent[x] = y;
            rank[y] = rank[y] + 1;
        }
    }
    // Find the root of the set in which element `k` belongs
    public int find(int k)
    {
        // if `k` is not the root
        if (parent[k] != k)
        {
            // path compression
            parent[k] = find(parent[k]);
        }
 
        return parent[k];
    }
 

    public boolean isInSameGroup(int a, int b) {
        // Return true if both a and b belong to the same set, otherwise return false
        return find(a) == find(b);
    }

    // Initialize weight for each node to be 1
    public DisjointSet(int N) {
        parent = new int[N + 1];
        this.rank = new int[N + 1];
        // Set the initial parent node to itself
        for (int i = 1; i <= N; ++i) {
            parent[i] = i;
            this.rank[i] = 0;
        }
    }
}



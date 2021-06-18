package algorithms.curated170.medium;

public class GraphValidTreeUnionFind {

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!unionFind.union(A, B)) {
                return false;
            }
        }

        return true;
    }

    class UnionFind {

        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int node = 0; node < n; node++) {
                parent[node] = node;
                rank[node] = 1;
            }
        }

        public int find(int key) {
            if (parent[key] != key) {
                parent[key] = find(parent[key]);
            }
            return parent[key];
        }

        public boolean union(int A, int B) {

            int rootA = find(A);
            int rootB = find(B);

            if (rootA == rootB) {
                return false;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
                rank[rootB] += rank[rootA];
            } else {
                parent[rootB] = rootA;
                rank[rootA] += rank[rootB];
            }
            return true;
        }
    }
}
package algorithms.curated170.medium.numberofconnectedcomponents;

public class NumberOfConnectedComponentsSetLogic {

    int roots[];

    public int countComponents(int[][] edges, int n) {
        if (n <= 1) {
            return 1;
        }

        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        for (int[] edge : edges) {
            int r1 = findRoot(edge[0]);
            int r2 = findRoot(edge[1]);

            if (r1 != r2) {
                roots[r1] = r2;
                n--;
            }
        }

        return n;
    }

    private int findRoot(int key) {
        if (key == roots[key])
        {
            return key;
        }
        return findRoot(roots[key]);
    }

    public static void main(String[] args) {
        var solution = new NumberOfConnectedComponentsSetLogic();

        int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        System.out.println(solution.countComponents(edges, 5)); // prints 2

        edges = new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 }, { 4, 1 } };
        System.out.println(solution.countComponents(edges, 5)); // prints 1

        edges = new int[][] { { 0, 1 } };
        System.out.println(solution.countComponents(edges, 5)); // prints 4

    }
}

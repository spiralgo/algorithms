package algorithms.curated170.medium.numberofconnectedcomponents;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfConnectedComponentsBFS {

    boolean[] visited;
    List<List<Integer>> connections = new ArrayList<>();

    public int countComponents(int n, int[][] edges) {
        if(n<=1)
        {
            return 1;
        }

        visited = new boolean[n];
        connections = new ArrayList<>();

        int num = 0;
        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            connections.get(edge[0]).add(edge[1]);
            connections.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            num += BFS(i);
        }

        return num;
    }

    private int BFS(int index) {
        if (visited[index]) {
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        q.addAll(connections.get(index));
        while(!q.isEmpty())
        {
            int n = q.poll();
            if(!visited[n])
            {
                visited[n] = true;
                q.addAll(connections.get(n));
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        var solution = new NumberOfConnectedComponentsBFS();

        int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        System.out.println(solution.countComponents(edges, 5)); //prints 2

        edges = new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 }, { 4, 1 } };
        System.out.println(solution.countComponents(edges, 5)); //prints 1

        edges = new int[][] { { 0, 1 } };
        System.out.println(solution.countComponents(edges, 5)); //prints 4

    }
}

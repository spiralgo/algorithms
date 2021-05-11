package algorithms.curated170.medium.parallelcourses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParallelCoursesDFS {

    private int maxPathLength = Integer.MIN_VALUE;
    private boolean hasCycle = false;
    HashMap<Integer, List<Integer>> graph;

    boolean[] visited;
    int[] depth;

    public int minimumSemesters(int n, int[][] relations) {
        graph = new HashMap<>();
        for (int[] relation : relations) {
            graph.putIfAbsent(relation[0], new ArrayList<>());
            graph.get(relation[0]).add(relation[1]);
        }

        depth = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            dfs(i);
            
            if(hasCycle)
            {
                return -1;
            }
        }
        return hasCycle ? -1 : maxPathLength;
    }

    private int dfs(int root) {
        if (visited[root]) {
            hasCycle = true;
        }

        if (depth[root] > 0 || hasCycle) {
            return depth[root];
        }

        visited[root] = true;
        int max = 0;

        if (graph.containsKey(root)) {
            for (int neighbor : graph.get(root)) {
                max = Math.max(max, dfs(neighbor));
            }
        }
        visited[root] = false;
        depth[root] = max + 1;
        maxPathLength = Math.max(maxPathLength, depth[root]);
        return depth[root];
    }

    public static void main(String[] args) {
        int[][] courses = new int[][] { { 1, 5 }, { 3, 2 }, { 3, 4 }, { 2, 6 }, { 4, 6 }, { 2, 5 }, { 5, 8 }, { 7, 8 },
                { 6, 9 }, { 7, 10 }, { 6, 8 }, { 8, 10 }, { 9, 10 } };
        var solution = new ParallelCoursesDFS();
        System.out.println(solution.minimumSemesters(10, courses));

        int[][] loopingCourses = new int[][] {{1,3}, {3,2}, {2,1}};
        var solution1 = new ParallelCoursesDFS();
        System.out.println(solution1.minimumSemesters(3, loopingCourses));
    }
}
package algorithms.curated170.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheMostSimilarPathInAGraphQueue {

    private static final int CITY = 0, LENGTH = 1;

    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        int t = targetPath.length;
        if (t == 0) {
            return new ArrayList<>();
        }

        int[][] graph = createGraph(n, roads);

        Deque<List<List<Integer>>> paths = new ArrayDeque<>();

        setPathStarts(n, names, targetPath, paths);

        return buildPathWithQueue(graph, paths, names, targetPath, n);
    }

    private List<Integer> buildPathWithQueue(int[][] graph, Deque<List<List<Integer>>> paths, String[] names, String[] targetPath,
            int n) {
        int t = targetPath.length;

        boolean[][] seen = new boolean[n][t];
        while (!paths.isEmpty()) {
            List<List<Integer>> path = paths.poll();
            List<Integer> currCityDist = path.get(0);
            List<Integer> currPath = path.get(1);

            int city = currCityDist.get(CITY), length = currCityDist.get(LENGTH);
            if (length == t - 1) {
                return currPath;
            }

            List<Integer> nextPath;
            for (int neighbor : graph[city]) {
                if (seen[neighbor][length] == true) {
                    continue;
                }

                seen[neighbor][length] = true;
                nextPath = new ArrayList<>(currPath);
                nextPath.add(neighbor);

                if (names[neighbor].equals(targetPath[length + 1])) {
                    paths.addFirst(List.of(List.of(neighbor, length + 1), nextPath));
                } else {
                    paths.addLast(List.of(List.of(neighbor, length + 1), nextPath));
                }
            }
        }
        return new ArrayList<>();
    }

    private void setPathStarts(int n, String[] names, String[] targetPath, Deque<List<List<Integer>>> q) {
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            if (targetPath[0].equals(names[i])) {
                q.addFirst(List.of(List.of(i, 0), list));
            } else {
                q.addLast(List.of(List.of(i, 0), list));
            }
        }
    }

    private int[][] createGraph(int n, int[][] roads) {
        int[][] graph = new int[n][];

        int[] adjacentCount = new int[n];
        for (int[] road : roads) {
            adjacentCount[road[0]]++;
            adjacentCount[road[1]]++;
        }

        for (int i = 0; i < n; i++) {
            graph[i] = new int[adjacentCount[i]];
        }
        int[] currIdx = new int[n];
        for (int[] edge : roads) {
            graph[edge[0]][currIdx[edge[0]]++] = edge[1];
            graph[edge[1]][currIdx[edge[1]]++] = edge[0];
        }
        return graph;
    }

}
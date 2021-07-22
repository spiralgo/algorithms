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
            List<Integer> curCityAndDist = path.get(0);
            List<Integer> currPathNodes = path.get(1);

            int city = curCityAndDist.get(CITY), length = curCityAndDist.get(LENGTH);
            if (length == t - 1) {
                return currPathNodes;
            }

            List<Integer> nextPathNodes;
            for (int neighbor : graph[city]) {
                if (seen[neighbor][length] == true) {
                    continue;
                }
                seen[neighbor][length] = true;

                nextPathNodes = new ArrayList<>(currPathNodes);
                nextPathNodes.add(neighbor);
                List<List<Integer>> nextPath = List.of(List.of(neighbor, length + 1), nextPathNodes);

                if (names[neighbor].equals(targetPath[length + 1])) {
                    paths.addFirst(nextPath);
                } else {
                    paths.addLast(nextPath);
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
        for (int[] road : roads) {
            graph[road[0]][currIdx[road[0]]++] = road[1];
            graph[road[1]][currIdx[road[1]]++] = road[0];
        }
        return graph;
    }

}
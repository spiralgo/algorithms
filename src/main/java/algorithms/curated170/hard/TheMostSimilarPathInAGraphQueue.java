package algorithms.curated170.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TheMostSimilarPathInAGraphQueue {
    
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        int t = targetPath.length;
        if (t == 0) {
            return new ArrayList<>();
        }

        int[][] graph = createGraph(n, roads);

        Deque<Path> paths = new ArrayDeque<>();

        setPathStarts(n, names, targetPath, paths);

        return buildPathWithQueue(graph, paths, names, targetPath, n);
    }

    private List<Integer> buildPathWithQueue(int[][] graph, Deque<Path> paths, String[] names, String[] targetPath,
            int n) {
        int t = targetPath.length;

        boolean[][] seen = new boolean[n][t];
        while (!paths.isEmpty()) {
            Path city = paths.poll();
            List<Integer> currPathNodes = city.currPathNodes;

            int length = currPathNodes.size();

            if (length == t) {
                return currPathNodes;
            }

            List<Integer> nextPathNodes;
            for (int neighbor : graph[city.cityIndex]) {
                if (seen[neighbor][length] == true) {
                    continue;
                }
                seen[neighbor][length] = true;

                nextPathNodes = new ArrayList<>(currPathNodes);
                nextPathNodes.add(neighbor);

                Path nextPath = new Path(neighbor, nextPathNodes);

                if (names[neighbor].equals(targetPath[length])) {
                    paths.addFirst(nextPath);
                } else {
                    paths.addLast(nextPath);
                }
            }
        }
        return new ArrayList<>();
    }

    private void setPathStarts(int n, String[] names, String[] targetPath, Deque<Path> q) {
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            Path initialCity = new Path(i, list);
            if (targetPath[0].equals(names[i])) {
                q.addFirst(initialCity);
            } else {
                q.addLast(initialCity);
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

    private class Path {
        Path(int cityIndex, List<Integer> currPathNodes) {
            this.cityIndex = cityIndex;
            this.currPathNodes = currPathNodes;
        }

        int cityIndex;
        List<Integer> currPathNodes;
    }

}
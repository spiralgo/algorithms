package algorithms.medium.courseschedule2;

import java.util.ArrayDeque;
import java.util.Deque;

public class CourseSchedule2BFS {

    int[] inDegree;
    Deque<Integer> currentCourses;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] digraph = makeGraph(prerequisites, numCourses);
        return sortTopologically(digraph, numCourses);
    }

    private int[] sortTopologically(int[][] digraph, int n) {
        int count = 0;
        int[] order = new int[n];
        int idx = 0;
        while (!currentCourses.isEmpty()) {
            int node = currentCourses.poll();
            order[idx++] = node;
            for (int k : digraph[node]) {
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    currentCourses.offer(k);
                }
            }
            count++;
        }
        if (count < n) {
            return new int[0];
        }
        return order;
    }

    private int[][] makeGraph(int[][] arcs, int n) {
        int[] outDegree = new int[n];
        inDegree = new int[n];
        for (int[] arc : arcs) {
            outDegree[arc[1]]++;
            inDegree[arc[0]]++;
        }

        int[][] digraph = new int[n][];
        currentCourses = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            digraph[i] = new int[outDegree[i]];
            if (inDegree[i] == 0) {
                currentCourses.offer(i);
            }
        }

        int[] nextDirectSuccessorIndex = new int[n];
        for (int[] arc : arcs) {
            digraph[arc[1]][nextDirectSuccessorIndex[arc[1]]++] = arc[0];
        }
        return digraph;
    }

}
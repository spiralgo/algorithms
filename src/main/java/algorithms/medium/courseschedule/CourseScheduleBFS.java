package algorithms.medium.courseschedule;

import java.util.ArrayDeque;
import java.util.Deque;

public class CourseScheduleBFS {

    int[] inDegree;
    Deque<Integer> currentCourses;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] digraph = makeGraph(prerequisites, numCourses);
        return sortTopologically(digraph, numCourses);
    }

    private boolean sortTopologically(int[][] digraph, int n) {
        int count = 0;
        
        while (!currentCourses.isEmpty()) {
            int node = currentCourses.poll();

            for (int k : digraph[node]) {
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    currentCourses.offer(k);
                }
            }
            count++;
        }

        if (count < n) {
            return false;
        }
        return true;
    }

    private int[][] makeGraph(int[][] arcs, int n) {
        int[] outDegree = new int[n];
        inDegree = new int[n];
        for (int[] arc : arcs) {
            outDegree[arc[0]]++;
            inDegree[arc[1]]++;
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
            digraph[arc[0]][nextDirectSuccessorIndex[arc[0]]++] = arc[1];
        }
        return digraph;
    }

}
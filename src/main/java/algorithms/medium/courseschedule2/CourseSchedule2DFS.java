package algorithms.medium.courseschedule2;

import java.util.Stack;

public class CourseSchedule2DFS {

    boolean[] visiting;
    boolean[] checked;
    int orderIdx;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] digraph = makeGraph(prerequisites, numCourses);
        visiting = new boolean[numCourses];
        checked = new boolean[numCourses];
        int[] order = new int[numCourses];
        orderIdx = numCourses;
        
        for (int i = 0; i < numCourses; i++) {
            if (!checked[i]) {
                if (!hasNoCycle(digraph, i, order)) {
                    return new int[0];
                }
            }
        }

        return order;
    }

    private int[][] makeGraph(int[][] arcs, int n) {
        int[] outDegree = new int[n];
        for (int[] arc : arcs) {
            outDegree[arc[1]]++;
        }

        int[][] digraph = new int[n][];
        for (int i = 0; i < n; i++) {
            digraph[i] = new int[outDegree[i]];
        }

        int[] nextDirectSuccessorIndex = new int[n];
        for (int[] arc : arcs) {
            digraph[arc[1]][nextDirectSuccessorIndex[arc[1]]++] = arc[0];
        }
        return digraph;
    }

    private boolean hasNoCycle(int[][] digraph, int currVertex, int[] order) {
        if (checked[currVertex]) {
            return true;
        }
        checked[currVertex] = true;

        visiting[currVertex] = true;
        for (int directSuccessor : digraph[currVertex]) {
            if (visiting[directSuccessor] || !hasNoCycle(digraph, directSuccessor, order)) {
                return false;
            }
        }
        order[--orderIdx] = currVertex;
        visiting[currVertex] = false;

        return true;
    }
}
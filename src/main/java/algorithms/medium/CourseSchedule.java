package algorithms.medium;

public class CourseSchedule {

    boolean[] visiting;
    boolean[] checked;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] digraph = makeGraph(prerequisites, numCourses);
        visiting = new boolean[numCourses];
        checked = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!checked[i]) {
                if (!hasNoCycle(digraph, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] makeGraph(int[][] arcs, int n) {
        int[] outDegree = new int[n];
        for (int[] arc : arcs) {
            outDegree[arc[0]]++;
        }

        int[][] digraph = new int[n][];
        for (int i = 0; i < n; i++) {
            digraph[i] = new int[outDegree[i]];
        }

        int[] nextDirectSuccessorIndex = new int[n];
        for (int[] arc : arcs) {
            digraph[arc[0]][nextDirectSuccessorIndex[arc[0]]++] = arc[1];
        }
        return digraph;
    }

    private boolean hasNoCycle(int[][] digraph, int currVertex) {
        if (checked[currVertex]) {
            return true;
        }
        checked[currVertex] = true;

        visiting[currVertex] = true;
        for (int directSuccessor : digraph[currVertex]) {
            if (visiting[directSuccessor] || !hasNoCycle(digraph, directSuccessor)) {
                return false;
            }
        }
        visiting[currVertex] = false;

        return true;
    }
}
package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathsfromSourceLeadToDestination {

    int[][] graph;
    boolean[] visiting;
    int dest;

    public boolean leadsToDestination(int n, int[][] arcs, int source, int destination) {
        this.dest = destination;
        visiting = new boolean[n];

        byte graphCreation = makeGraph(arcs, n, source);
        if (graphCreation == DEST_HAS_ARC) {
            return false;
        } else if (graphCreation == SOURCE_HAS_NO_ARC) {
            return source == destination;
        }

        return hasAllPathsToDestination(source);
    }

    final byte GRAPH_CREATED = 1;
    final byte DEST_HAS_ARC = 0;
    final byte SOURCE_HAS_NO_ARC = 2;
    
    byte makeGraph(int[][] arcs, int n, int source) {
        int[] outDegree = new int[n];
        for (int[] arc : arcs) {
            outDegree[arc[0]]++;
        }

        if (outDegree[dest] > 0) {
            return DEST_HAS_ARC;
        }
        if (outDegree[source] == 0) {
            return SOURCE_HAS_NO_ARC;
        }

        graph = new int[n][];
        for (int i = 0; i < n; i++) {
            graph[i] = new int[outDegree[i]];
        }

        int[] nextDirectSuccessorIndex = new int[n];
        for (int[] arc : arcs) {
            graph[arc[0]][nextDirectSuccessorIndex[arc[0]]++] = arc[1];
        }
        return GRAPH_CREATED;
    }

    boolean hasAllPathsToDestination(int currVertex) {

        if (graph[currVertex].length == 0 && currVertex != dest) {
            return false;
        }
        visiting[currVertex] = true;

        for (int directSuccessor : graph[currVertex]) {
            if (visiting[directSuccessor] || !hasAllPathsToDestination(directSuccessor)) {
                return false;
            }
        }

        visiting[currVertex] = false;
        return true;
    }

}
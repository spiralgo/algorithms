package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathsfromSourceLeadToDestination {

    int[][] graph;
    boolean[] visiting;
    int dest;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        this.dest = destination;
        visiting = new boolean[n];

        byte graphCreation = makeGraph(edges, n, source);
        if (graphCreation == DEST_HAS_PATH) {
            return false;
        } else if (graphCreation == SOURCE_HAS_NO_PATH) {
            return source == destination;
        }

        return hasAllPathsToDestination(source);
    }

    final byte GRAPH_CREATED = 1;
    final byte DEST_HAS_PATH = 0;
    final byte SOURCE_HAS_NO_PATH = 2;
    
    byte makeGraph(int[][] edges, int n, int source) {
        int[] outDegree = new int[n];
        for (int[] edge : edges) {
            outDegree[edge[0]]++;
        }

        if (outDegree[dest] > 0) {
            return DEST_HAS_PATH;
        }
        if (outDegree[source] == 0) {
            return SOURCE_HAS_NO_PATH;
        }

        graph = new int[n][];
        for (int i = 0; i < n; i++) {
            graph[i] = new int[outDegree[i]];
        }

        int[] nextDirectSuccessorIndex = new int[n];
        for (int[] edge : edges) {
            graph[edge[0]][nextDirectSuccessorIndex[edge[0]]++] = edge[1];
        }
        return GRAPH_CREATED;
    }

    boolean hasAllPathsToDestination(int currVertex) {

        if (graph[currVertex].length == 0 && currVertex != dest) {
            return false;
        }
        visiting[currVertex] = true;

        for (int directedSuccessor : graph[currVertex]) {
            if (visiting[directedSuccessor] || !hasAllPathsToDestination(directedSuccessor)) {
                return false;
            }
        }

        visiting[currVertex] = false;
        return true;
    }

}
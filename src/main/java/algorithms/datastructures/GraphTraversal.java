/*
Source: https://www.baeldung.com/java-graphs
*/
package algorithms.datastructures;

import algorithms.datastructures.Graph.Vertex;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
 

public class GraphTraversal {
    static Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {              
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    static Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph= graph.createGraph();
        
       ;
        System.out.println(depthFirstTraversal(graph, "1").toString());
    }
}
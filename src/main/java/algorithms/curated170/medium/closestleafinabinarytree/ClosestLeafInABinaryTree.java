package algorithms.curated170.medium.binarytreeverticalordertraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithms.datastructures.TreeNode;

public class ClosestLeafInABinaryTree {

  Map<TreeNode, List<TreeNode>> graph;
  int k;
  TreeNode nodeK = null;

  public int findClosestLeaf(TreeNode root, int k) {
    if (root.left == null && root.right == null) {
      return k;
    }

    this.k = k;
    graph = new HashMap<>();
    createGraphWithDFS(root, null);

    return shortestPathBFS(root);
  }

  private int shortestPathBFS(TreeNode root) {
    Deque<TreeNode> queue = new ArrayDeque<>();
    boolean[] seen = new boolean[1001];

    queue.offer(nodeK);
    seen[k] = true;

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        if (graph.get(node).size() <= 1 && node != root) {
          return node.val;
        }
        for (TreeNode nei : graph.get(node)) {
          if (!seen[nei.val]) {
            seen[nei.val] = true;
            queue.add(nei);
          }
        }
      }
    }

    throw null;
  }

  public void createGraphWithDFS(TreeNode node, TreeNode parent) {
    if (node != null) {
      if (node.val == k) {
        nodeK = node;
      }
      graph.putIfAbsent(node, new ArrayList<>());
      if (parent != null) {
        graph.putIfAbsent(parent, new ArrayList<>());
        graph.get(node).add(parent);
        graph.get(parent).add(node);
      }

      createGraphWithDFS(node.left, node);
      createGraphWithDFS(node.right, node);
    }
  }

  public static void main(String[] args) {
    var solution = new ClosestLeafInABinaryTree();

    TreeNode tn1 = new TreeNode(1);
    TreeNode t0 = new TreeNode(2, null, tn1);
    TreeNode t1 = new TreeNode(5);
    TreeNode t2 = new TreeNode(4, null, t1);
    TreeNode t3 = new TreeNode(3, t0, t2);
    TreeNode root = new TreeNode(9, null, t3);

  }
}

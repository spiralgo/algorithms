package algorithms.curated170.medium.closestleafinabinarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithms.datastructures.TreeNode;

public class ClosestLeafInABinaryTreeGraphBFS {

  Map<Integer, List<TreeNode>> graph = new HashMap<>();

  public int findClosestLeaf(TreeNode root, int k) {
    if (root.left == null && root.right == null) {
      return k;
    }

    createGraphWithDFS(root, null);

    return shortestPathBFS(root, k);
  }

  private int shortestPathBFS(TreeNode root, int k) {
    Deque<Integer> queue = new ArrayDeque<>();
    boolean[] seen = new boolean[1001];

    queue.offer(k);
    seen[k] = true;

    while (!queue.isEmpty()) {
      Integer node = queue.poll();

      List<TreeNode> children = graph.get(node);
      if (node != root.val && children.size() <= 1) {
        return node;
      }
      for (TreeNode adjacentNode : children) {
        if (!seen[adjacentNode.val]) {
          seen[adjacentNode.val] = true;
          queue.add(adjacentNode.val);
        }
      }

    }

    return -1;
  }

  public void createGraphWithDFS(TreeNode node, TreeNode parent) {
    if (node != null) {

      graph.put(node.val, new ArrayList<>());
      if (parent != null) {
        graph.get(node.val).add(parent);
        graph.get(parent.val).add(node);
      }

      createGraphWithDFS(node.left, node);
      createGraphWithDFS(node.right, node);
    }
  }
}

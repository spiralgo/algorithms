package algorithms.curated170.medium.braceexpansion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.TreeMap;

import algorithms.datastructures.TreeNode;

public class BinaryTreeVerticalOrderTraversalBFS {
  public List<List<Integer>> verticalOrder(TreeNode root) {

    if (root == null) {
      return Collections.emptyList();
    }

    TreeMap<Integer, ArrayList<Integer>> xPosMap = new TreeMap<>();

    Deque<NodePosPair> q = new ArrayDeque<>();
    q.offer(new NodePosPair(root, 0));

    while (!q.isEmpty()) {
      NodePosPair npp = q.poll();
      npp.placeIntoMap(xPosMap);
      npp.queueChildren(q);
    }

    List<List<Integer>> verticalOrderAtXPos = new ArrayList<>(xPosMap.values());

    verticalOrderAtXPos.addAll(xPosMap.values());

    return verticalOrderAtXPos;
  }

  private class NodePosPair {
    final TreeNode node;
    final int x;

    void placeIntoMap(TreeMap<Integer, ArrayList<Integer>> xPosMap) {
      xPosMap.putIfAbsent(x, new ArrayList<>());
      xPosMap.get(x).add(node.val);
    }

    void queueChildren(Deque<NodePosPair> q) {
      if (node.left != null) {
        q.offer(new NodePosPair(node.left, x - 1));
      }
      if (node.right != null) {
        q.offer(new NodePosPair(node.right, x + 1));
      }
    }

    NodePosPair(TreeNode tn, int x) {
      this.node = tn;
      this.x = x;
    }
  }

  public static void main(String[] args) {
    var solution = new BinaryTreeVerticalOrderTraversalBFS();

    TreeNode tn1 = new TreeNode(1);
    TreeNode t0 = new TreeNode(2, null, tn1);
    TreeNode t1 = new TreeNode(5);
    TreeNode t2 = new TreeNode(4, null, t1);
    TreeNode t3 = new TreeNode(3, t0, t2);
    TreeNode root = new TreeNode(9, null, t3);

    System.out.println(solution.verticalOrder(root));
  }
}

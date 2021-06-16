package algorithms.curated170.medium.closestleafinabinarytree;

import algorithms.datastructures.TreeNode;

public class ClosestLeafInABinaryTreeSearchOtherBranch {
  int distance, val;

  public int findClosestLeaf(TreeNode root, int k) {
    distance = Integer.MAX_VALUE;
    val = -1;
    findTarget(root, k);
    return val;
  }

  private int findTarget(TreeNode root, int target) {
    if (root == null) {
      return -1;
    }
    if (root.val == target) {
      seacrhClosestLeaf(root, 0);
      return 1;
    }
    int left = findTarget(root.left, target);
    int right = -1;
    if (left > 0) {
      seacrhClosestLeaf(root.right, ++left);
    } else {
      right = findTarget(root.right, target);
      if (right > 0) {
        seacrhClosestLeaf(root.left, ++right);
      }
    }

    return Math.max(left, right);
  }

  private void seacrhClosestLeaf(TreeNode root, int dist) {
    if (root == null)
      return;
    if (root.left == null && root.right == null) {
      if (dist <= distance) {
        distance = dist;
        val = root.val;
      }
    }
    seacrhClosestLeaf(root.left, dist + 1);
    seacrhClosestLeaf(root.right, dist + 1);
  }

  public static void main(String[] args) {
    var solution = new ClosestLeafInABinaryTreeSearchOtherBranch();

    TreeNode tn1 = new TreeNode(1);
    TreeNode t0 = new TreeNode(2, null, tn1);
    TreeNode t1 = new TreeNode(5);
    TreeNode t2 = new TreeNode(4, null, t1);
    TreeNode t3 = new TreeNode(3, t0, t2);
    TreeNode root = new TreeNode(9, null, t3);

  }
}

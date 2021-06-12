package algorithms.curated170.medium.braceexpansion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeMap;

import algorithms.datastructures.TreeNode;

public class BinaryTreeVerticalOrderTraversalBFS {
  public List<List<Integer>> verticalOrder(TreeNode root) {

    if (root == null) {
      return new ArrayList<>();
    }

    TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();

    Deque<Pair> q = new ArrayDeque<>();
    q.offer(new Pair(root, 0));

    while (!q.isEmpty()) {
      Pair p = q.poll();

      tree.putIfAbsent(p.x, new ArrayList<>());
      tree.get(p.x).add(p.tn.val);

      if (p.tn.left != null) {
        q.offer(new Pair(p.tn.left, p.x - 1));
      }

      if (p.tn.right != null) {
        q.offer(new Pair(p.tn.right, p.x + 1));
      }
    }

    List<List<Integer>> ret = new ArrayList<>();

    for (var k : tree.values()) {
      ret.add(k);
    }
    
    return ret;
  }

  private class Pair {
    TreeNode tn;
    int x = 0;

    Pair(TreeNode tn, int x) {
      this.tn = tn;
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

package algorithms.curated170.medium.binarytreeverticalordertraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import algorithms.datastructures.TreeNode;

public class BinaryTreeVerticalOrderTraversalDFS {

  HashMap<Integer, ArrayList<int[]>> columnTable = new HashMap<>();
  int minColumn = 0, maxColumn = 0;

  public List<List<Integer>> verticalOrder(TreeNode root) {

    if (root == null) {
      return Collections.emptyList();
    }

    DFS(root, 0, 0);

    List<List<Integer>> columnsAtXPos = new ArrayList<>(maxColumn - minColumn + 2);

    for (int i = minColumn; i <= maxColumn; i++) {

      Collections.sort(columnTable.get(i), (p1, p2) -> p1[0] - p2[0]);

      List<Integer> sortedColumn = new ArrayList<>();

      for (int[] rowValPair : columnTable.get(i)) {
        sortedColumn.add(rowValPair[1]);
      }

      columnsAtXPos.add(sortedColumn);
    }

    return columnsAtXPos;
  }

  private void DFS(TreeNode root, int row, int col) {

    if (root == null) {
      return;
    }

    columnTable.putIfAbsent(col, new ArrayList<>());

    columnTable.get(col).add(new int[] { row, root.val });
    minColumn = Math.min(minColumn, col);
    maxColumn = Math.max(maxColumn, col);

    DFS(root.left, row + 1, col - 1);
    DFS(root.right, row + 1, col + 1);
  }

  public static void main(String[] args) {
    var solution = new BinaryTreeVerticalOrderTraversalDFS();

    TreeNode tn1 = new TreeNode(1);
    TreeNode t0 = new TreeNode(2, null, tn1);
    TreeNode t1 = new TreeNode(5);
    TreeNode t2 = new TreeNode(4, null, t1);
    TreeNode t3 = new TreeNode(3, t0, t2);
    TreeNode root = new TreeNode(9, null, t3);

    System.out.println(solution.verticalOrder(root));
  }

}

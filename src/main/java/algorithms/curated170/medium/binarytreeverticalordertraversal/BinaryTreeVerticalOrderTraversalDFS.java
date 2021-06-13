package algorithms.curated170.medium.braceexpansion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithms.datastructures.Pair;
import algorithms.datastructures.TreeNode;

public class BinaryTreeVerticalOrderTraversalDFS {

  Map<Integer, ArrayList<Pair<Integer, Integer>>> columnTable = new HashMap<>();
  int minColumn = 0, maxColumn = 0;

  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> output = new ArrayList<>();
    if (root == null) {
      return output;
    }

    this.DFS(root, 0, 0);

    // Retrieve the resuts, by ordering by column and sorting by row
    for (int i = minColumn; i < maxColumn + 1; ++i) {

      Collections.sort(columnTable.get(i), new Comparator<Pair<Integer, Integer>>() {
        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
          return p1.first - p2.first;
        }
      });

      List<Integer> sortedColumn = new ArrayList<>();
      for (Pair<Integer, Integer> p : columnTable.get(i)) {
        sortedColumn.add(p.second);
      }
      output.add(sortedColumn);
    }

    return output;
  }

  private void DFS(TreeNode node, Integer row, Integer column) {
    if (node == null)
      return;

    if (!columnTable.containsKey(column)) {
      this.columnTable.put(column, new ArrayList<Pair<Integer, Integer>>());
    }

    this.columnTable.get(column).add(new Pair<Integer, Integer>(row, node.val));
    this.minColumn = Math.min(minColumn, column);
    this.maxColumn = Math.max(maxColumn, column);
    // preorder DFS traversal
    this.DFS(node.left, row + 1, column - 1);
    this.DFS(node.right, row + 1, column + 1);
  }

}

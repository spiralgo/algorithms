package algorithms.easy.binarytreepreordertraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algorithms.datastructures.TreeNode;

public class BinaryTreePreorderTraversal {

	List<Integer> preorder = new ArrayList<>();

	public List<Integer> preorderTraversal(TreeNode root) {

		if (root == null) {
			return Collections.emptyList();
		}

		DFSpreorder(root);
		return preorder;
	}

	private void DFSpreorder(TreeNode root) {
          if (root == null) return;
          preorder.add(root.val);
          DFSpreorder(root.left);
          DFSpreorder(root.right);
	}

}

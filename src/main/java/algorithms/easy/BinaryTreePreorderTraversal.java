package algorithms.easy;

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

		preorder.add(root.val);

		if (root.left != null) {
			DFSpreorder(root.left);
		}

		if (root.right != null) {
			DFSpreorder(root.right);
		}
	}

}

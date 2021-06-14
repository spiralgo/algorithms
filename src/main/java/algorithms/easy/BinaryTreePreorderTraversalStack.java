package algorithms.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import algorithms.datastructures.TreeNode;

public class BinaryTreePreorderTraversalStack {

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<Integer> preorder = new ArrayList<>();

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			preorder.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return preorder;
	}

}

package algorithms.curated170.medium.findrootofnarytree;

import algorithms.datastructures.TreeNode;

public class InorderSuccessorInBSTDFS {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode successor = inorderSuccessor(root.left, p);
            return (successor != null) ? successor : root;
        }
    }

}

package algorithms.curated170.medium.findrootofnarytree;

import algorithms.datastructures.TreeNode;

public class InorderSuccessorInBSTIterative {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode successor = null;

        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return successor;
    }
}

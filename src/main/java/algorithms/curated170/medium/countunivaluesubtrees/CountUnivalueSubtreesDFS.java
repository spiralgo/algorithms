package algorithms.curated170.countunivaluesubtrees.medium;

import algorithms.datastructures.TreeNode;

public class CountUnivalueSubtreesDFS {

    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        isUnivalSubtree(root);
        return count;
    }

    private boolean isUnivalSubtree(TreeNode root) {

        boolean isUnival = true;
        if (root.left != null) {
            isUnival = root.left.val == root.val && isUnivalSubtree(root.left);
        }
        if (root.left != null && isUnival) {
            isUnival = root.right.val == root.val && isUnivalSubtree(root.right);
        }
        if (isUnival) {
            count++;
            return true;
        }
        return false;
    }

}

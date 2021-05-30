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
            isUnival = isUnivalSubtree(root.left) && root.left.val == root.val;
        }
        if (root.right!= null) {
            isUnival = isUnival & isUnivalSubtree(root.right) && root.right.val == root.val;
        }
        if (isUnival) {
            count++;
            return true;
        }
        return false;
    }

}

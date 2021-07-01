package algorithms.curated170.medium;

import algorithms.datastructures.TreeNode;

public class LargestBSTSubtree {

    final int MIN_VAL = 0;
    final int MAX_VAL = 1;
    final int BST_SUBTREE_SIZE = 2;

    public int largestBSTSubtree(TreeNode root) {
        return getSizeOfLargestBST(root)[BST_SUBTREE_SIZE];
    }

    private int[] getSizeOfLargestBST(TreeNode node) {
        if (node == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }
        int[] left = getSizeOfLargestBST(node.left);
        int[] right = getSizeOfLargestBST(node.right);
        
        if (isValidBST(node, left, right)) {
            return new int[] { Math.min(node.val, left[MIN_VAL]), Math.max(node.val, right[MAX_VAL]),
                    left[BST_SUBTREE_SIZE] + right[BST_SUBTREE_SIZE] + 1 };
        } else {
            return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE,
                    Math.max(left[BST_SUBTREE_SIZE], right[BST_SUBTREE_SIZE]) };
        }
    }

    private boolean isValidBST(TreeNode node, int[] left, int[] right) {
        return node.val > left[MAX_VAL] && node.val < right[MIN_VAL];
    }

}

package algorithms.curated170.medium;

import algorithms.datastructures.TreeNode;

public class BinaryTreeLongestConsecutiveSequence2 {

    private int maxLength = 0;
    private final byte INCREASING = 0, DECREASING = 1;

    public int longestConsecutive(TreeNode root) {
        
        DFS(root);

        return maxLength;
    }

    private int[] DFS(TreeNode root) {

        int incr = 0, decr = 0;

        if (root.left != null) {
            int[] branchLeft = DFS(root.left);
            if (root.left.val > root.val) {
                incr = branchLeft[INCREASING];
            } else if (root.val > root.left.val) {
                decr = branchLeft[DECREASING];
            }
        }

        if (root.right != null) {
            int[] branchRight = DFS(root.right);
            if (root.right.val > root.val) {
                incr = Math.max(incr, branchRight[INCREASING]);
            } else if (root.val > root.right.val) {
                decr = Math.max(decr, branchRight[DECREASING]);
            }
        }
        
        maxLength = Math.max(maxLength, incr + decr + 1);
        return new int[] { incr + 1, decr + 1 };
    }

    public static void main(String[] args) {

        var solution = new BinaryTreeLongestConsecutiveSequence2();
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode t0 = new TreeNode(2, null, tn1);
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4, null, t1);
        TreeNode t3 = new TreeNode(3, t0, t2);
        TreeNode root = new TreeNode(1, null, t3);

        System.out.println(solution.longestConsecutive(root));

    }
}
package algorithms.curated170.medium;

import algorithms.datastructures.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {

     private int maxLength = 0;

    public int longestConsecutive(TreeNode root) {

        if (root == null) {
            return 0;
        }

        DFS(root, 0);

        return maxLength;
    }

    private int DFS(TreeNode root, int parVal) {
        if (root == null) {
            return 0;
        }

        int consecLength = 1;

        int left = DFS(root.left, root.val);
        int right = DFS(root.right, root.val);
        consecLength += Math.max(left, right);

        maxLength = Math.max(maxLength, consecLength);
        return root.val - parVal == 1 ? consecLength : 0;
    }

    public static void main(String[] args) {
        
        var solution = new BinaryTreeLongestConsecutiveSequence();

        TreeNode t0 = new TreeNode(2);
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4, null, t1);
        TreeNode t3 = new TreeNode(3, t0, t2);
        TreeNode root = new TreeNode(1, null, t3);

        System.out.println(solution.longestConsecutive(root));

    }
}
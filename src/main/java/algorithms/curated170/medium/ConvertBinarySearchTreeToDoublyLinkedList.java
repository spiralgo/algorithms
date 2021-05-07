package algorithms.curated170.medium;

import algorithms.datastructures.TreeNode;

public class ConvertBinarySearchTreeToDoublyLinkedList {
    private TreeNode headPointer = new TreeNode(0);
    private TreeNode lastNode = headPointer;

    public TreeNode treeToDoublyList(TreeNode root) {
        convertTree(root);
        lastNode.right = headPointer.right;
        headPointer.right.left = lastNode;
        return headPointer.right;
    }

    private void convertTree(TreeNode root) {
        if (root == null) {
            return;
        }
        convertTree(root.left);
        lastNode.right = root;
        root.left = lastNode;
        lastNode = root;
        convertTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(3, t0, t1);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(8, t3, t4);
        TreeNode root = new TreeNode(6, t2, t5);
        TreeNode head = new ConvertBinarySearchTreeToDoublyLinkedList().treeToDoublyList(root);
        int i = 0;
        while (i<14) {
            System.out.print(head.val + " ");
            head = head.right;
            i++;
        } //prints 1 3 4 6 7 8 9 1 3 4 6 7 8 9 , which shows that it loops through the circular doubly linked list.
    }

}

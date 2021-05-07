package algorithms.curated170.medium;

import algorithms.datastructures.Node;

public class ConvertBinarySearchTreeToDoublyLinkedList {
    private Node headPointer = new Node(0);
    private Node lastNode = headPointer;

    public Node treeToDoublyList(Node root) {
        convertTree(root);
        lastNode.right = headPointer.right;
        if(headPointer.right != null)
        {
            headPointer.right.left = lastNode;
        }
        return headPointer.right;
    }

    private void convertTree(Node root) {
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
        Node t0 = new Node(1);
        Node t1 = new Node(4);
        Node t2 = new Node(3, t0, t1);
        Node t3 = new Node(7);
        Node t4 = new Node(9);
        Node t5 = new Node(8, t3, t4);
        Node root = new Node(6, t2, t5);
        Node head = new ConvertBinarySearchTreeToDoublyLinkedList().treeToDoublyList(root);
        int i = 0;
        while (i<14) {
            System.out.print(head.value + " ");
            head = head.right;
            i++;
        } //prints 1 3 4 6 7 8 9 1 3 4 6 7 8 9 , which shows that it loops through the circular doubly linked list.
    }

}

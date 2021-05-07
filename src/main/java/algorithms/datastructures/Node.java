package algorithms.datastructures;

public class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
    public Node(int value, Node left, Node right) {
        this.value = value;
        right = null;
        left = null;
    }
}

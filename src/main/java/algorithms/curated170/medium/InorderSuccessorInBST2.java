package algorithms.curated170.medium;

public class InorderSuccessorInBST2 {

    public Node inorderSuccessor(Node start) {
        if (start == null) {
            return null;
        }
        if (start.right != null)
            return findIS(start.right);

        while (start.parent != null && start.parent.left != start) {

            start = start.parent;
        }

        return start.parent;

    }

    private Node findIS(Node n) {
        return n.left == null ? n : findIS(n.left);
    }

    private class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }
}

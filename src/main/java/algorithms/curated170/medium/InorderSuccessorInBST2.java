package algorithms.curated170.medium;

public class InorderSuccessorInBST2 {

    public Node sucNode(Node start) {
        if (start == null) {
            return null;
        }
        if (start.right == null) {
            while (start.parent != null) {
                if (start.parent.left == start) {
                    return start.parent;
                }
                start = start.parent;
            }
            return null;
        }
        return findSuc(start);
    }

    private Node findSuc(Node n) {
        return n.left == null ? n : findSuc(n.left);
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

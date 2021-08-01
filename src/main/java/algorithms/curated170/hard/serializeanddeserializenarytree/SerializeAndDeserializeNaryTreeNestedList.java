package algorithms.curated170.hard.serializeanddeserializenarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializeAndDeserializeNaryTreeNestedList {

    static class Codec {

        public String serialize(Node root) {
            if (root == null) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            sb.append("[");
            for (Node child : root.children) {
                sb.append(serialize(child));
            }
            sb.append("]");
            return sb.toString();
        }

        public Node deserialize(String data) {
            Node root = null;
            Stack<Node> stack = new Stack<>();
            int i = 0;

            while (i < data.length()) {
                int start = i;

                while (i < data.length() && Character.isDigit(data.charAt(i))) {
                    i++;
                }

                if (start == i) {
                    Node child = stack.pop();
                    if (stack.isEmpty()) {
                        root = child;
                        break;
                    } else {
                        stack.peek().children.add(child);
                    }
                } else {
                    Node n = new Node();
                    n.val = Integer.parseInt(data.substring(start, i));
                    n.children = new ArrayList<>();
                    stack.push(n);
                }
                i++;
            }
            return root;
        }
    }

    static class Node {
        public int val;
        public List<Node> children = new ArrayList<>();

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Node c1 = new Node(10);
        Node c2 = new Node(77);
        Node c3 = new Node(24);
        Node root = new Node(90, List.of(c1, c2, c3));

        var codec = new Codec();
        String coded = codec.serialize(root);
        System.out.println(coded);
        System.out.println(codec.serialize(codec.deserialize(coded)));
    }
}

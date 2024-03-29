package algorithms.curated170.hard.serializeanddeserializenarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import algorithms.curated170.medium.Node;

public class SerializeAndDeserializeNaryTreeChildCount {

    static class Codec {

        public String serialize(Node root) {
            List<String> list = new ArrayList<>();
            encode(root, list);
            return String.join(",", list);
        }

        private void encode(Node root, List<String> list) {
            if (root == null) {
                return;
            } else {
                list.add(String.valueOf(root.val));
                list.add(String.valueOf(root.children.size()));
                for (Node child : root.children) {
                    encode(child, list);
                }
            }
        }

        public Node deserialize(String data) {
            if (data.isEmpty())
                return null;

            String[] nodes = data.split(",");
            Queue<String> q = new LinkedList<>(Arrays.asList(nodes));
            return decode(q);
        }

        private Node decode(Queue<String> q) {
            Node root = new Node();
            root.val = Integer.parseInt(q.poll());
            int size = Integer.parseInt(q.poll());
            root.children = new ArrayList<Node>(size);
            for (int i = 0; i < size; i++) {
                root.children.add(decode(q));
            }
            return root;
        }
    }


    public static void main(String[] args) {
        Node c1 = new Node(10);
        Node c2 = new Node(77);
        Node c3 = new Node(24);
        Node root = new Node(90,   new ArrayList<>(List.of(c1, c2, c3)));

        var codec = new Codec();
        String coded = codec.serialize(root);
        System.out.println(coded);
        System.out.println(codec.serialize(codec.deserialize(coded)));
    }
}

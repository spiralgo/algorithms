package algorithms.curated170.hard.serializeanddeserializenarytree;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeNaryTreeUnicode {

    static class Codec {

        
        public String serialize(Node root) {
            StringBuilder sb = new StringBuilder();
            this.encode(root, sb);
            return sb.toString();
        }
        
        private void encode(Node node, StringBuilder sb) {
            if (node == null)
            return;
            sb.append((char) (node.val + '0'));
            for (Node child : node.children) {
                encode(child, sb);
            }
            sb.append('#');
        }
        
        public Node deserialize(String data) {
            if (data.isEmpty())
            return null;
            return decode(data, new int[1]);
            
        }
        
        private static final int VAL = 0;

        private Node decode(String data, int[] index) {
            if (index[VAL] == data.length())
                return null;
            Node node = new Node(data.charAt(index[0]) - '0', new ArrayList<Node>());
            index[VAL]++;
            while (data.charAt(index[0]) != '#')
                node.children.add(decode(data, index));
            index[VAL]++;
            return node;

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

package algorithms.curated170.medium.findrootofnarytree;

import algorithms.curated170.medium.Node;
import java.util.List;

 
public class FindRootofNAryTree {
public Node findRoot(List<Node> tree) {

        Integer valueSum = 0;

        for (Node node : tree) {
            // the value is added as a parent node
            valueSum += node.val;
            for (Node child : node.children)
                // the value is deducted as a child node.
                valueSum -= child.val;
        }

        for (Node node : tree) {
            if (node.val == valueSum) {
                return node;
            }
        }
        return null;
     
    }
}

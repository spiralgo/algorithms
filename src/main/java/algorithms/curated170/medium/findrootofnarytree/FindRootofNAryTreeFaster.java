package algorithms.curated170.medium.findrootofnarytree;

import java.util.List;
import algorithms.curated170.medium.Node;

 
public class FindRootofNAryTreeFaster {
class Solution {
  
    public Node findRoot(List<Node> tree) {
        int target = 0;

        for (Node node : tree) {
             target ^= node.val;

            for (Node child : node.children) {
                 target ^= child.val;
            }
        }

         for (Node node : tree) {
            if (node.val == target) {
                return node;
            }
        }

        return null;
    }
}
}

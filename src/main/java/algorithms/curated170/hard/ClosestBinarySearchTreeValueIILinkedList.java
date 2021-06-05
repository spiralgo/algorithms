package algorithms.curated170.hard;

import algorithms.datastructures.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class ClosestBinarySearchTreeValueIILinkedList {

    LinkedList<Integer> result;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        inorder(root, target, k);

        return result;
    }

    private void inorder(TreeNode curr, double target, int k) {
        if (curr == null) {
            return;
        }

        inorder(curr.left, target, k);
        if (result.size() < k) {
            result.add(curr.val);
        } else if (Math.abs(curr.val - target) < Math.abs(result.getFirst() - target)) {
                result.removeFirst();
                result.add(curr.val);
            
        }

        inorder(curr.right, target, k);
    }
}

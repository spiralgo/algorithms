package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.List;

import algorithms.datastructures.TreeNode;

public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) {
            return boundary;
        }
        boundary.add(root.val);

         if (root.left != null || root.right != null) {
             getLeftBorder(root.left, boundary);
             getLeaves(root, boundary);
             getRightBorder(root.right, boundary);
        }

        return boundary;
    }

    private void getLeftBorder(TreeNode root, List<Integer> boundary) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        boundary.add(root.val);
        if (root.left != null) {
            getLeftBorder(root.left, boundary);
        } else {
            getLeftBorder(root.right, boundary);
        }
    }

    private void getRightBorder(TreeNode root, List<Integer> boundary) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right != null) {
            getRightBorder(root.right, boundary);
        } else {
            getRightBorder(root.left, boundary);
        }
        boundary.add(root.val);
    }

    private void getLeaves(TreeNode root, List<Integer> boundary) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            boundary.add(root.val);
            return;
        }
        getLeaves(root.left, boundary);
        getLeaves(root.right, boundary);
    }
}

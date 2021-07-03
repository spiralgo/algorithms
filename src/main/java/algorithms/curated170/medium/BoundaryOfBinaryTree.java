package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.List;

import algorithms.datastructures.TreeNode;

public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);

        printLeftBorder(root.left, res);
        if (root.left != null || root.right != null) {
            printLeaves(root, res);
        }
        printRightBorder(root.right, res);

        return res;
    }

    private void printLeftBorder(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        res.add(root.val);
        if (root.left != null) {
            printLeftBorder(root.left, res);
        } else {
            printLeftBorder(root.right, res);
        }
    }

    private void printRightBorder(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right != null) {
            printRightBorder(root.right, res);
        } else {
            printRightBorder(root.left, res);
        }
        res.add(root.val);
    }

    private void printLeaves(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        printLeaves(root.left, res);
        printLeaves(root.right, res);
    }
}
package algorithms.curated170.hard;

import algorithms.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class EncodeNaryTreeToBinaryTree {

    class Codec {

        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }
            return encodeLeftRight(root, true);
        }

        private TreeNode encodeLeftRight(Node root, boolean goLeft) {
            TreeNode tRoot = new TreeNode(root.val);
            TreeNode currChild = tRoot;

            for (Node child : root.children) {
                if (goLeft) {
                    currChild.left = encodeLeftRight(child, false);
                    currChild = currChild.left;
                } else {
                    currChild.right = encodeLeftRight(child, true);
                    currChild = currChild.right;
                }
            }

            return tRoot;
        }

        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return decodeLeftRight(root, true);
        }

        private Node decodeLeftRight(TreeNode root, boolean goLeft) {
            Node nRoot = new Node(root.val, new ArrayList<>());
            TreeNode currChild = root;

            if (goLeft) {
                while (currChild.left != null) {
                    nRoot.children.add(decodeLeftRight(currChild.left, false));
                    currChild = currChild.left;
                }
            } else {
                while (currChild.right != null) {
                    nRoot.children.add(decodeLeftRight(currChild.right, true));
                    currChild = currChild.right;
                }
            }

            return nRoot;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

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
}

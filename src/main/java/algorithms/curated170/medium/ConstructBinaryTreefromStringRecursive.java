package algorithms.curated170.medium;

import algorithms.datastructures.TreeNode;

public class ConstructBinaryTreefromStringRecursive {

    public static void main(String[] args) {
        String s = "-60(9(8)(7))(5)";
        ConstructBinaryTreefromStringRecursive cbts = new ConstructBinaryTreefromStringRecursive();
        TreeNode previous = cbts.str2tree(s);
        System.out.println();
    }

    String globalString;
    int len;
    int i = 0;

    public TreeNode str2tree(String s) {

        globalString = s;
        len = globalString.length();
        return str2treeInner(null);
    }

    public TreeNode str2treeInner(TreeNode root) {

        if (i >= len) {
            return root;
        }

        char ch = globalString.charAt(i);
        switch (ch) {
            case ')':
                i++;

                return root;

            case '(':
                i++;
                if (root.left == null) {
                    root.left = str2treeInner(root.left);

                } else {
                    root.right = str2treeInner(root.right);

                }
                break;
            default:
                int start = i;
                int sign = 1;
                if (ch == '-') {
                    i++;
                    sign = -1;
                }

                int num = 0;
                while (i < len && Character.isDigit(globalString.charAt(i))) {
                    num = num * 10 + globalString.charAt(i++) - '0';
                }

                root = new TreeNode(num * sign);

        }

        return str2treeInner(root);

    }
}

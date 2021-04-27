package algorithms.curated170.medium;

import algorithms.datastructures.TreeNode;

public class MaximumAvarageSubtree {
    double result = 0;

    public double solution(TreeNode root) {
        searchDownTree(root);
        return result;
    }

    private int[] searchDownTree(TreeNode root) {
        // A depth-first search algorithm recursively comparing the avarages of subtrees

        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = searchDownTree(root.left), right = searchDownTree(root.right);
        int n = left[1] + right[1] + 1;
        int sum = left[0] + right[0] + root.val;
        double avgL = left[1] == 0 ? 0 : (double) left[0] / left[1];
        double avgR = right[1] == 0 ? 0 : (double) right[0] / right[1];
        
        double avg = Math.max((double) sum / n, Math.max(avgL, avgR));

        result = Math.max(result, avg);
        return new int[] { sum, n };
    }

    public static void main(String[] args) {

        var n0 = new TreeNode(6);
        var n1 = new TreeNode(1);
        var n2 = new TreeNode(7, null, n1);
        var n = new TreeNode(5, n0, n2);
        var mas = new MaximumAvarageSubtree();
        System.out.println(mas.solution(n)); // prints 6.0 (6/1 > (7+1)/2)

        mas = new MaximumAvarageSubtree();
        var n3 = new TreeNode(15);
        n.right = n3;
        n3.left = n2;
        n2.right = new TreeNode(5);
        System.out.println(mas.solution(n)); // prints 7.666666666666667 (15+7+5)/3
    }
}

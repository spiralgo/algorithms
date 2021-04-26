package algorithms.curated170.medium;

import algorithms.datastructures.TreeNode;

public class MaximumAvarageSubtree {
    public static double solution(TreeNode root) {
        var leftPair = root.left == null ? new double[2] : solutionHelper(root.left);
        var rightPair = root.right == null ? new double[2] : solutionHelper(root.right);
        double avarLeft = leftPair[0]/leftPair[1];
        double avarRight = rightPair[0]/rightPair[1];
        return Math.max(avarLeft, avarRight);
    }

    private static double[] solutionHelper(TreeNode root) {
        double[] avaragePair = new double[2];
        checkSides(root.left, avaragePair);
        checkSides(root.right, avaragePair);
        avaragePair[0] += root.val;
        avaragePair[1]++;
        return avaragePair;
    }
    private static void checkSides(TreeNode side, double[] avaragePair)
    {
        if(side==null) {return;}
        double[] sideHand = solutionHelper(side);
        avaragePair[0] += sideHand[0];
        avaragePair[1] += sideHand[1];
    }

    public static void main(String[] args) {
        var n0 = new TreeNode(6);
        var n2 = new TreeNode(7);
        var n1 = new TreeNode(1, null, n2);
        var n = new TreeNode(5,n0, n1);
        System.out.println(solution(n)); //prints 6.0

        var n3 = new TreeNode(15);
        n1.left = n3;
        System.out.println(solution(n)); //prints 7.666666666666667
    }
}

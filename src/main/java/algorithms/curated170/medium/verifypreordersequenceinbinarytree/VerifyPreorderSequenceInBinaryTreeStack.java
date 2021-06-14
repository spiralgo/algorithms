package algorithms.curated170.medium.verifypreordersequenceinbinarytree;

import java.util.Stack;

public class VerifyPreorderSequenceInBinaryTreeStack {

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lowest = Integer.MIN_VALUE;
        for (int n : preorder) {
            if (n < lowest) {
                return false;
            }
            while (!stack.isEmpty() && n > stack.peek()) {
                lowest = stack.pop();
            }
            stack.push(n);
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new VerifyPreorderSequenceInBinaryTreeStack();
        int[] preorder = {5,2,1,3,4,7,6,9};
        
        System.out.println(solution.verifyPreorder(preorder)); // true

        preorder = new int[]{5,2,1,3,-1,7,6,9}; 
        System.out.println(solution.verifyPreorder(preorder)); // false
    }
}

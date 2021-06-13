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
}

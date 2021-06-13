package algorithms.curated170.medium.verifypreordersequenceinbinarytree;

import java.util.Stack;

public class VerifyPreorderSequenceInBinaryTreeModifyInputArray {

    public boolean verifyPreorder(int[] preorder) {
        int lowest = Integer.MIN_VALUE, i = -1;
        for (int n : preorder) {
            if (n < lowest) {
                return false;
            }
            while (i >= 0 && n > preorder[i]) {
                lowest = preorder[i--];
            }
            preorder[++i] = n;
        }
        return true;
    }

}

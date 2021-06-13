package algorithms.curated170.medium.verifypreordersequenceinbinarytree;

import java.util.Stack;

public class VerifyPreorderSequenceInBinaryTreeDFS {

    int i;
    public boolean verifyPreorder(int[] preorder) {
        DFS(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return i == preorder.length;
    }

    private void DFS(int[] preorder,int lower, int upper )
    {
        if (i >= preorder.length || preorder[i] < lower || preorder[i] > upper)
        return;

        int val = preorder[i++];
        DFS(preorder, lower, val);
        DFS(preorder, val, upper);
    }
}

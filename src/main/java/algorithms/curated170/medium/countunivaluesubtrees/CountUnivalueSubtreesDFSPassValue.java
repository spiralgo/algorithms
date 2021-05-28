package algorithms.curated170.countunivaluesubtrees.medium;

import algorithms.datastructures.TreeNode;

public class CountUnivalueSubtreesDFSPassValue {

    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUnivaluePart(root, 0);
        return count;
    }

    private boolean isUnivaluePart(TreeNode root, int parentVal)
    {
        if(root == null)
        {
            return true;
        }

        if(!isUnivaluePart(root.left, root.val)&& !isUnivaluePart(root.right, root.val))
        {
            return false;
        }
        count++;
        return root.val == parentVal;
    }

}

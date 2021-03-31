package algorithms.curated170.easy;
 
import algorithms.datastructures.TreeNode;

public class ClosestBinarySearchTreeValue {
 
    int currentBest = -1;
    public int closestValue(TreeNode root, double target) {
        if(root == null) return currentBest;
        
        int currentVal = root.val;
      
        if(currentBest == -1)
           currentBest = root.val;
   
        currentBest = Math.abs(currentVal - target) < Math.abs(currentBest - target) ? currentVal : currentBest;
        
        
        if(target < currentVal)
        {
           closestValue(root.left, target);
        }
        else if(target > currentVal)
        {
           closestValue(root.right, target);
        }
        return currentBest;
    }
 
}
 
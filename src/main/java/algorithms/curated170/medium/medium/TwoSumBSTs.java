package algorithms.curated170.medium.medium;

import algorithms.datastructures.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;

 

 
public class TwoSumBSTs {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
        TreeNode node2 = new TreeNode(1, new TreeNode(0), new TreeNode(3));
       
        TwoSumBSTs ts = new TwoSumBSTs();
        System.out.println(ts.twoSumBSTs(node1, node2, 5));
    }
    public  boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
       TwoSumBSTs.target = target;
      
      return  preOrder(root1, root2);
 
    }
    static int target;
    static boolean preOrder(TreeNode root, TreeNode root2){
        if(root == null) 
            return false;
         
        if(preOrderBS(root2, target - root.val)) 
            return true;
        
        
        return preOrder(root.left, root2) || preOrder(root.right, root2);
    }
      static boolean preOrderBS(TreeNode root, int target){
        if(root == null) 
            return false;
         
        boolean resultLeft = false; 
        boolean resultRight = false; 
        if(root.val == target){
           return true;  
        }else if(root.val < target){
            resultLeft = preOrderBS(root.right, target);
        }else if(root.val > target){
            resultRight= preOrderBS(root.left, target);
        }
          return resultLeft || resultRight;
          
   
    
    }
}

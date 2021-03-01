package algorithms;
 
import algorithms.datastructures.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List; 
import org.apache.commons.lang3.tuple.MutablePair;
class FindLeavesOfBinaryTree  {
    private List<MutablePair<Integer, Integer>> pairs;
    
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        
        node2.left = node4;
        node2.right = node5;
        
        node1.left = node2;
        node1.right = node3;
        
        FindLeavesOfBinaryTree findLeavesOfBinaryTree = new  FindLeavesOfBinaryTree();
        
        List<List<Integer>> result =  findLeavesOfBinaryTree.findLeaves(node1);
        
       String textToPrint =  Arrays.deepToString(result.toArray());
    
        System.out.println(textToPrint);
    }
           
    
    private List<List<Integer>> solution;
    
    private int getHeight(TreeNode root) {
        
        // return -1 for null nodes
        if (root == null) {
            return -1;
        }
        
        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        
        if (this.solution.size() == currHeight) {
            this.solution.add(new ArrayList<>());
        }
        
        this.solution.get(currHeight).add(root.val);
        
        return currHeight;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
           
        this.solution = new ArrayList<>();
        
        getHeight(root);
        
        return this.solution;
    }
}
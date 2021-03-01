package algorithms; 
 
import algorithms.datastructures.Node;

public class Playground {
    public static void main(String[] args) {
          Node node = new Node(1);
          node.left = new Node(2);
          Node node3 = new Node(3);
          node3.left = new Node(4);
          node3.right = new Node(5);
          node.right = node3;
  
         preOrder(node);
    }
   
   static void preOrder(Node node){
        if(node == null) 
            return;
        
        System.out.println(node.value);
        preOrder(node.left); 
        preOrder(node.right);
         
    }
    
}

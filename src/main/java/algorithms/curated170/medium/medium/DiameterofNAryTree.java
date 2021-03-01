package algorithms.curated170.medium.medium;
 
public class DiameterofNAryTree {
    public static void main(String[] args) {
        Node node3 = new Node(3);
       
        node3.children.add(new Node(5));
        node3.children.add(new Node(6));

        Node node1 = new Node(1);
        node1.children.add(node3);
        
        node1.children.add(new Node(2));
        node1.children.add(new Node(4));
        
        diameter(node1);
        
    }
    
      static  int diameter = -1;
        
        private static int getHeight(Node root) {
         
        if (root.children.size()== 0) {
            return 0;
        }
    
        int max1 = -1, max2 = -1;

        for(Node child: root.children){
            int currHeight = getHeight(child) + 1;
    
            if(currHeight > max1){
                max2 = max1;
                max1 = currHeight;
              
            }else if(currHeight > max2){
                max2 = currHeight;
            }     
             
            diameter = Math.max(max1 + max2, diameter);
        }
      
        return max1;
    }
    
    public static int diameter(Node root) {
        
        getHeight(root);
        System.out.println(diameter);
        return diameter;
    }
}

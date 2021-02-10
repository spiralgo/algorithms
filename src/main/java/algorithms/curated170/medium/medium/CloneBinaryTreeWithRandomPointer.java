package algorithms.curated170.medium.medium;

import java.util.HashMap;
import java.util.Map;

 
public class CloneBinaryTreeWithRandomPointer {
 public NodeCopy copyRandomBinaryTree(NodeCopy root) {
        Map<NodeCopy,NodeCopy> map = new HashMap<>();
        return dfs(root, map);
    }
    
    public NodeCopy dfs(NodeCopy root, Map<NodeCopy,NodeCopy> map){
        if (root==null) return null;        
        
        if (map.containsKey(root)) return map.get(root);
        
        NodeCopy newNode = new NodeCopy(root.val);
        map.put(root,newNode);
        
        newNode.left=dfs(root.left,map);
        newNode.right=dfs(root.right,map);
        newNode.random=dfs(root.random,map);
        
        return newNode;
        
    }
}
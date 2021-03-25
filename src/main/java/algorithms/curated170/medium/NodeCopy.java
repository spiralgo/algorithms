package algorithms.curated170.medium;
 
public class NodeCopy {
      int val;
      NodeCopy left;
      NodeCopy right;
      NodeCopy random;
      
      NodeCopy() {}
      
      NodeCopy(int val) { this.val = val; }
      NodeCopy(int val, NodeCopy left, 
                NodeCopy right, NodeCopy random) {
          this.val = val;
          this.left = left;
          this.right = right;
          this.random = random;
      }
  }
  
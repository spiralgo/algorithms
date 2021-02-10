package algorithms.curated170.medium.medium;
 
import java.util.ArrayList;
import java.util.List;

public class CloneNaryTree {
 public Node cloneTree(Node r) {
    if (r == null)
        return null;
    var new_r = new Node(r.val);
    for (var child: r.children)
        new_r.children.add(cloneTree(child));
    return new_r;    
}
}

package algorithms;
  
import java.util.ArrayList;
import java.util.List;

public class Playground {
    public static void main(String[] args) {
      List<NestedInteger> list = new ArrayList<>();
    
      List<NestedInteger> innerList = new ArrayList<>();
      innerList.add(new NestedInteger(1));
      innerList.add(new NestedInteger(1));
      NestedInteger n = new NestedInteger(list);
      
      list.add(n);
      list.add(new NestedInteger(2));
    }
     
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return -1;
    }
}


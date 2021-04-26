package algorithms.curated170.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

 
public class NestedListWeightSum2Queue {
public int depthSumInverse(List<NestedInteger> nestedList) {
        
         Queue<NestedInteger> productionLine = new LinkedList<>();
        
         for (NestedInteger nestedInteger : nestedList) {
            productionLine.add(nestedInteger);
        }
         
    
         int totalSum = 0;
         int layerSum = 0;
         while (!productionLine.isEmpty()) {  
              int size = productionLine.size();
              int individualSum = 0;
             for (int i = 0; i < size; i++) {
              
          
                NestedInteger nestedInteger = productionLine.poll();

                if(nestedInteger.isInteger()){
                    individualSum = individualSum + nestedInteger.getInteger();

                }else{
                    List<NestedInteger> pack = nestedInteger.getList();
                    for (NestedInteger nestedIntegerInner : pack) {
                         productionLine.add(nestedIntegerInner);
                    }
                }
               
             }
             layerSum = layerSum + individualSum;
             totalSum = totalSum + layerSum;
            
        }
         return totalSum;
    }

}

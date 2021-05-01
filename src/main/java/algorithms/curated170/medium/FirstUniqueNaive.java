package algorithms.curated170.medium;
  
import java.util.LinkedHashMap;
import java.util.Map;

 

 class FirstUniqueNaive {

     LinkedHashMap<Integer, Integer> queue = new LinkedHashMap();
           
    public FirstUniqueNaive(int[] nums) {
     for(int item: nums){
         queue.merge(item, 1, Integer::sum);
     }
    }
    
    public int showFirstUnique() {
        for(Map.Entry<Integer, Integer> entry: queue.entrySet()){
         if(entry.getValue() == 1){
             return entry.getKey();
         }
        }
        return -1; 
    }
    
    public void add(int value) {
        queue.merge(value, 1, Integer::sum);
    }
}
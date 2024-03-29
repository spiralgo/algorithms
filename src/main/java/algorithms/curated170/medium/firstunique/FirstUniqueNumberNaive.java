package algorithms.curated170.medium.firstunique;
  
import java.util.LinkedHashMap;
import java.util.Map;

 

 class FirstUniqueNumberNaive {

     LinkedHashMap<Integer, Integer> queue = new LinkedHashMap();
           
    public FirstUniqueNumberNaive(int[] nums) {
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
package algorithms.datastructures;

import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class DataStructuresPlayground {
    
    public static void main(String[] args) {
        
        // ARRAY
        String[] arrayString = new String[]{"ger�ek elma", "ger�ek armut", "ger�ek muz"};
        System.out.println(arrayString[1]);
        
        // HASHMAP
        HashMap<String, String> hashMap = new  HashMap<String, String>();
        hashMap.put("elma", "ger�ek elma");
        hashMap.put("armut", "ger�ek armut");
        hashMap.put("muz", "ger�ek muz");
      
        
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
        
        
        //ARRAYLIST
          ArrayList<String> arrayList = new ArrayList<String>();
          arrayList.add("gerçek elma");
          arrayList.add("gerçek armut");
          arrayList.add("gerçek muz");
          
          
          
          System.out.println(arrayList.get(1));
          
          
          System.out.println("Stack:");
          Stack<String> stack = new Stack<>();
          stack.add("9");
          stack.add("8");
          stack.add("1");
          stack.add("3");
          

          Stack<String> stackTemp  = (Stack<String>) stack.clone();
          while (!stackTemp.empty()) {            
              System.out.println(stackTemp.pop());
        }
         System.out.println(stack.toString());
          
          Queue<String> queue  =   new LinkedList<String>(); 
          queue.add("5");
          queue.add("6");
          queue.add("7");
          queue.add("8");
        
         System.out.println(queue.toString());

        
    }
}
 
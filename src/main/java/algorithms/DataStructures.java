/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class DataStructures {
    
    public static void main(String[] args) {
        
        // ARRAY
        String[] arrayString = new String[]{"gerçek elma", "gerçek armut", "gerçek muz"};
        System.out.println(arrayString[1]);
        
        // HASHMAP
        HashMap<String, String> hashMap = new  HashMap<String, String>();
        hashMap.put("elma", "gerçek elma");
        hashMap.put("armut", "gerçek armut");
        hashMap.put("muz", "gerçek muz");
        
        System.out.println(hashMap.get("armut"));
        
        //ARRAYLIST
          ArrayList<String> arrayList = new ArrayList<String>();
          arrayList.add("gerçek elma");
          arrayList.add("gerçek armut");
          arrayList.add("gerçek muz");
          
          System.out.println(arrayList.get(1));
          
         
          
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.HashMap;
 

/**
 *
 * @author ASUS
 */
public class TwoSums {
   public int[] twoSum(int[] nums, int target) {
          
            HashMap hm = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if(hm.containsKey(target-num)){
                    return new int[] { Integer.valueOf(hm.get(target-num).toString()), i };
                    
                }else{
                      hm.put(num, i);
                }
             
            }
          throw new IllegalArgumentException("No two sum solution");
     }
}
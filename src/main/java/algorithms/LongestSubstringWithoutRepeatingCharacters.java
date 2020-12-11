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
public class LongestSubstringWithoutRepeatingCharacters {
       public int lengthOfLongestSubstring(String s) {
         if(s == null || s.length() == 0)
             return 0;
       
         if(s.trim().length() == 0)
             return 1;
         
         int max = 0;
        
         HashMap hm = new HashMap<Character, Integer>();
         int leftPointer = 0;
           
         for (int i = 0; i < s.length(); i++) {
             char ch = s.charAt(i);
             if(hm.containsKey(ch)){
                 leftPointer = (int) hm.get(ch);
                 int currentWindowSize = i- leftPointer + 1;
                 if(currentWindowSize>max){
                     max = currentWindowSize;
                            
                 }
             }else{
                 hm.put(ch, i+1);
                 max++ ;
             }
           }
          
         return max;
    }
}

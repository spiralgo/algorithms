package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

 
public class SimpleHeadsOrTails {
public static void main(String[] args) {
      SimpleHeadsOrTails simpleHeadsOrTails = new SimpleHeadsOrTails();
      HashMap<Integer, Integer> rolls = new HashMap<>();
      for (int i = 1; i < 100000000; i++) {
          int count = 0;
          int number = simpleHeadsOrTails.rollTheDice();
          if(rolls.containsKey(number)){
              count = rolls.get(number) + 1 ;
          }
          rolls.put(number, count);
       }
       simpleHeadsOrTails.printTheResult(rolls);
    }
void printTheResult(HashMap<Integer, Integer> rolls){
    for (Map.Entry<Integer, Integer> entry : rolls.entrySet()) {
        Integer key = entry.getKey();
        Integer value = entry.getValue();
        String result="";
        if(key==1){
            result = "yazı";
        }else{
            result = "tura";
        }
        System.out.println("Yüz milyon atıştan " + value +" tanesi "+ result +" gelmiştir.");
        
    } 
}
  
 int rollTheDice(){
     Random random = new Random();
     return random.nextInt(2) + 1;
 }    
}

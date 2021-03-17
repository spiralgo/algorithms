package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

 
public class SimpleDice {
  public static void main(String[] args) {
      SimpleDice simpleDice = new SimpleDice();
      HashMap<Integer, Integer> rolls = new HashMap<>();
      for (int i = 1; i < 1000; i++) {
          int count = 0;
          int number = simpleDice.rollTheDice() + simpleDice.rollTheDice();
          if(rolls.containsKey(number)){
              count = rolls.get(number) + 1 ;
          }
          rolls.put(number, count);
       }
       simpleDice.printTheResult(rolls);
    }
void printTheResult(HashMap<Integer, Integer> rolls){
    for (Map.Entry<Integer, Integer> entry : rolls.entrySet()) {
        Integer key = entry.getKey();
        Integer value = entry.getValue();
        System.out.println("1000 atıştan " + value +" tanesi "+ key +" gelmiştir.");
        
    } 
}
  
 int rollTheDice(){
     Random random = new Random();
     return random.nextInt(6) + 1;
 }    
}

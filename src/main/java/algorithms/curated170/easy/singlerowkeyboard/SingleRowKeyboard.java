 
package algorithms.curated170.easy.singlerowkeyboard;
 
import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        int time = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        int startIndex = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int currTime = Math.abs(startIndex - map.get(c));
            time += currTime;
            startIndex = map.get(c);
        }
        return time;
    }
}

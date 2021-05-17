package algorithms.curated170.easy.singlerowkeyboard;

 
public class SingleRowKeyboardArray {
 
    public int calculateTime(String keyboard, String word) {
        int[] index = new int[26];
        for (int i = 0; i < keyboard.length(); ++i) {
            index[keyboard.charAt(i) - 'a'] = i;
        }
        
        int time = 0, pos = 0;
        for (char c : word.toCharArray()) {
            int i = index[c - 'a'];
            time += Math.abs(i - pos);
            pos = i;
        }
        return time;
    }
}
 
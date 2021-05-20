package algorithms.curated170.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class RearrangeStringKDistanceApart {
    private final int unassigned = -1073741824;
    public String rearrangeString(String s, int k) {

        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        var keys = counter.keySet();
        
        StringBuilder rearrangedStr = new StringBuilder();
        int[] lastIndices = new int[26];
        Arrays.fill(lastIndices, unassigned);
        int index = 0; 
        

        while (!counter.isEmpty()) {
            for (char key : keys.toArray(new Character[0])) {
                if (!counter.containsKey(key)) {
                    continue;
                }
                rearrangedStr.append(key);
                counter.put(key, counter.get(key) - 1);
                if (counter.get(key) == 0) {
                    counter.remove(key);
                }
                if((index - lastIndices[letterIndex(key)]) < k)
                {
                    return "";
                }
                lastIndices[letterIndex(key)] = index;
                index++;
            }
        }
        return rearrangedStr.toString();    
    }

    private final int LETTER_a = 97;
    private int letterIndex(char key) {
        return key - LETTER_a;
    }
    
    public static void main(String[] args) {

        var solution = new RearrangeStringKDistanceApart();
        solution.rearrangeString("aadbbcc", 4); // prints abcdabc
        solution.rearrangeString("aadbbcc", 5); // prints empty
    }
}

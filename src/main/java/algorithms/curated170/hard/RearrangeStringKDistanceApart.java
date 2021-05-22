package algorithms.curated170.hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class RearrangeStringKDistanceApart {
    /**
     *
     */
    private static final int ALPHABET_SIZE = 26;
    private static final int UNASSIGNED = -1073741824;

    int[] counter;
    HashMap<Integer, PriorityQueue<Character>> layers;

    public String rearrangeString(String s, int k) {

        countLetters(s);

        setLetterLayers();

        StringBuilder rearrangedStr = new StringBuilder();

        while (!layers.isEmpty()) {

            List<Integer> keyList = Arrays.asList(layers.keySet().toArray(new Integer[0]));
            Collections.reverse(keyList);

            HashMap<Integer, PriorityQueue<Character>> newLayers = new HashMap<>();
            int layerBreadth = k-1;
            for (int layer : keyList) {
                var pq = layers.get(layer);

                if (layerBreadth < 0) {
                    if (!newLayers.containsKey(layer)) {
                        newLayers.put(layer, pq);
                    } else {
                        newLayers.get(layer).addAll(pq);
                    }
                    continue;
                }

                PriorityQueue<Character> nextLayer = new PriorityQueue<>();
                while (!pq.isEmpty()) {
                    char c = pq.poll();
                    if (layerBreadth > -1) {
                        rearrangedStr.append(c);
                        nextLayer.add(c);
                        layerBreadth--;
                    } else {
                        newLayers.putIfAbsent(layer, new PriorityQueue<>());
                        newLayers.get(layer).add(c);
                    }
                }
                if(layer > 1)
                {
                    newLayers.put(layer - 1, nextLayer);
                }
            }

            if(!newLayers.isEmpty() && layerBreadth > -1)
            {
                return "";
            }
            layers = newLayers;
        }

        return rearrangedStr.toString();
    }

    private void setLetterLayers() {
        layers = new HashMap<>();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            int count = counter[i];
            if (count == 0) {
                continue;
            }
            layers.putIfAbsent(count, new PriorityQueue<>());
            layers.get(count).add(getLetterOfIndex(i));
        }
    }

    private void countLetters(String s) {
        counter = new int[ALPHABET_SIZE];
        for (char c : s.toCharArray()) {
            counter[getIndexOfLetter(c)]++;
        }
    }

    private static final int LETTER_a = 97;

    private static int getIndexOfLetter(char key) {
        return key - LETTER_a;
    }

    private static char getLetterOfIndex(int index) {
        return (char) (LETTER_a + index);
    }

    public static void main(String[] args) {

        var solution = new RearrangeStringKDistanceApart();

        String s1 =  solution.rearrangeString("aadbbbcce", 4); 
        System.out.println(s1); // prints bacdbaceb
        s1 = solution.rearrangeString("abb", 2); 
        System.out.println(s1); // prints bab
        s1 = solution.rearrangeString("abb", 3); 
        System.out.println(s1); // prints nothing
        s1 =  solution.rearrangeString("aadbbbcce", 5); 
        System.out.println(s1); // prints empty 
        String s2 =  solution.rearrangeString("aaadbbcc", 2); 
        System.out.println(s2); // prints abacabcd
        s2 =  solution.rearrangeString("aaabc", 3); 
        System.out.println(s2); // prints empty 
        s2 =  solution.rearrangeString("aabbcc", 3); 
        System.out.println(s2); // prints abcabc 
    }
}

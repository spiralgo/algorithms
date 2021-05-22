package algorithms.curated170.hard;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

import algorithms.util.collections.Reversed;

public class RearrangeStringKDistanceApart {

    private static final int ALPHABET_SIZE = 26;

    int[] counter;
    TreeMap<Integer, PriorityQueue<Character>> layers;
    StringBuilder rearrangedStr;

    public String rearrangeString(String s, int k) {

        countLetters(s);

        setLetterLayers();

        rearrangedStr = new StringBuilder();

        return tryRearrangeString(k) ? rearrangedStr.toString() : "";
    }

    private boolean tryRearrangeString(int k) {
        while (!layers.isEmpty()) {
            TreeMap<Integer, PriorityQueue<Character>> newLayers = new TreeMap<>(Collections.reverseOrder());
            Integer[] layerBreadth = new Integer[]{k - 1};
            for (int layer : layers.navigableKeySet()) {
                PriorityQueue<Character> currLayer = layers.get(layer);

                if (layerBreadth[0] < 0) {
                    if (!newLayers.containsKey(layer)) {
                        newLayers.put(layer, currLayer);
                    } else {
                        newLayers.get(layer).addAll(currLayer);
                    }
                    continue;
                }

                checkLayer(currLayer, layerBreadth, newLayers, layer);
            }

            if (!newLayers.isEmpty() && layerBreadth[0] > -1) {
                return false;
            }
            layers = newLayers;
        }
        return true;
    }

    private void checkLayer(PriorityQueue<Character> currLayer, Integer[] layerBreadth,
            TreeMap<Integer, PriorityQueue<Character>> newLayers, final int layer) {

        PriorityQueue<Character> nextLayer = new PriorityQueue<>();
        while (!currLayer.isEmpty()) {
            char c = currLayer.poll();
            if (layerBreadth[0] > -1) {
                rearrangedStr.append(c);
                nextLayer.add(c);
                layerBreadth[0]--;
            } else {
                newLayers.putIfAbsent(layer, new PriorityQueue<>());
                newLayers.get(layer).add(c);
            }
        }
        if (layer > 1) {
            newLayers.put(layer - 1, nextLayer);
        }
    }

    private void setLetterLayers() {
        layers = new TreeMap<>(Collections.reverseOrder());
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

        String s1 = solution.rearrangeString("aadbbbcce", 4);
        System.out.println(s1); // prints bacdbaceb
        s1 = solution.rearrangeString("abb", 2);
        System.out.println(s1); // prints bab
        s1 = solution.rearrangeString("abb", 3);
        System.out.println(s1); // prints empty
        s1 = solution.rearrangeString("aadbbbcce", 5);
        System.out.println(s1); // prints empty
        
        String s2 = solution.rearrangeString("aaadbbcc", 2);
        System.out.println(s2); // prints abacabcd
        s2 = solution.rearrangeString("aaabc", 3);
        System.out.println(s2); // prints empty
        s2 = solution.rearrangeString("aabbcc", 3);
        System.out.println(s2); // prints abcabc
    }
}

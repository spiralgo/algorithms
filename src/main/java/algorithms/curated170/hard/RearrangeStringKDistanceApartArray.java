package algorithms.curated170.hard;

public class RearrangeStringKDistanceApartArray {

    private static final int ALPHABET_SIZE = 26;

    int[] counter;
    boolean[][] layers;
    int maxLayer = 0;

    StringBuilder rearrangedStr;

    public String rearrangeString(String s, int k) {

        if (k < 2) {
            return s;
        }
        countLetters(s);

        setLetterLayers();
        
        rearrangedStr = new StringBuilder();
        
        return tryRearrangeString(k) ? rearrangedStr.toString() : "";
    }

    private boolean tryRearrangeString(int k)
    {
        boolean hasNext = true;

        while (hasNext) {
            boolean[][] newLayers = new boolean[maxLayer][ALPHABET_SIZE];
            hasNext = false;
            int layerBreadth = k;
            for (int layer = maxLayer - 1; layer > 0; layer--) {
                boolean[] currLayer = layers[layer];
                for (int letter = 0; letter < ALPHABET_SIZE; letter++) {
                    if (currLayer[letter]) {
                        currLayer[letter] = false;
                        if (layerBreadth > 0) {
                            rearrangedStr.append(getLetterOfIndex(letter));
                            layerBreadth--;
                            if (layer > 1) {
                                hasNext = true;
                            }
                            newLayers[layer - 1][letter] = true;
                        }
                        else
                        {
                            newLayers[layer][letter] = true;   
                            hasNext = true;
                        }
                    }
                }
            }
            if(hasNext && layerBreadth > 0)
            {
                return false;
            }
            layers = newLayers;
        }

        return true;
    }
    
    private void setLetterLayers() {
        layers = new boolean[maxLayer][ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            layers[counter[i]][i] = true;
        }
    }

    private void countLetters(String s) {
        counter = new int[ALPHABET_SIZE];
        for (char c : s.toCharArray()) {
            counter[getIndexOfLetter(c)]++;
        }

        maxLayer = 0;
        for (int count : counter) {
            maxLayer = Math.max(maxLayer, count + 1);
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

        var solution = new RearrangeStringKDistanceApartArray();

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
        String s3 = solution.rearrangeString("a", 0);
        System.out.println(s3); // prints a
    }
}

package algorithms.curated170.hard;

public class RearrangeStringKDistanceApartArray {

    private static final int ALPHABET_SIZE = 26;

    int[] counter;
    int[] validIndices;
    boolean[][] layers;

    StringBuilder rearrangedStr;

    public String rearrangeString(String s, int k) {

        if (k < 2) {
            return s;
        }
        countLetters(s);

        validIndices = new int[ALPHABET_SIZE];
        
        rearrangedStr = new StringBuilder();

        
        return  tryRearrangeStr(k, s.length()) ? rearrangedStr.toString() : "";
    }

    private boolean tryRearrangeStr(int k, int len)
    {
        for(int i = 0; i<len; i++)
        {
            int letter = getCanditate(i);
            
            if(letter == -1)
            {
                return  false;
            }
            counter[letter]--;
            validIndices[letter] = i+k;
            rearrangedStr.append(getLetterOfIndex(letter));
        }
        return true;
    }

    int getCanditate(int index)
    {
        int maxCount = 0;
        int canditate = -1;

        for(int i = 0; i<ALPHABET_SIZE; i++)
        {
            if(counter[i] > maxCount && validIndices[i] <= index)
            {
                maxCount = counter[i];
                canditate = i;
            }
        }
        return canditate;
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

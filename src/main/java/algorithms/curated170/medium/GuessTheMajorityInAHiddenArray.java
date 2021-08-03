package algorithms.curated170.medium;

 public class GuessTheMajorityInAHiddenArray {
    
    public int guessMajority(ArrayReader reader) {
        int n = reader.length();
        boolean[] val = new boolean[5];
        int secondFourWindowCount = compareFirstFiveValues(reader, val);

        int countA = 0, countB = 0, indexA = -1, indexB = -1;
        for (int i = 0; i < 5; i++) {
            if (val[i]) {
                countA++;
                indexA = i;
            } else {
                countB++;
                indexB = i;
            }
        }

        return compareNextWindows(reader, n, val, secondFourWindowCount, countA, countB, indexA, indexB);
    }

    private int compareFirstFiveValues(ArrayReader reader, boolean[] val) {
        int a = reader.query(0, 1, 2, 3);
        int b = reader.query(0, 2, 3, 4);
        int c = reader.query(0, 1, 3, 4);
        int d = reader.query(0, 1, 2, 4);
        int e = reader.query(1, 2, 3, 4);
        val[0] = true;
        val[1] = (b == e);
        val[2] = (b == c) ? val[1] : !val[1];
        val[3] = (c == d) ? val[2] : !val[2];
        val[4] = (a == d) ? val[3] : !val[3];
        return e;
    }

    private int compareNextWindows(ArrayReader reader, int n, boolean[] val, int secondFourWindowCount, int countA, int countB,
            int indexA, int indexB) {

        int prevWin = secondFourWindowCount;

        for (int i = 5; i < n; i++) {
            int curWin = reader.query(i - 3, i - 2, i - 1, i);

            val[i % 5] = compareToMissingVal(val, prevWin, i, curWin);
            
            if (val[i % 5]) {
                countA++;
                indexA = i;
            } else {
                countB++;
                indexB = i;
            }

            prevWin = curWin;
        }
        
        if (countA == countB) {
            return -1;
        }
        return countA > countB ? indexA : indexB;
    }

    private boolean compareToMissingVal(boolean[] val, int prevWin, int i, int curWin) {
        return (curWin == prevWin) ? val[(i - 4) % 5] : !val[(i - 4) % 5];
    }



    public static void main(String[] args) {

    }
}
 
 
  interface ArrayReader {
  
    // Compares 4 different elements in the array
     // return 4 if the values of the 4 elements are the same (0 or 1).
     // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
      // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
      public int query(int a, int b, int c, int d);
 
      // Returns the length of the array
     public int length();
  };
 
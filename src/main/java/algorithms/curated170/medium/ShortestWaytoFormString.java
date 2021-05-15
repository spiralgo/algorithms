package algorithms.curated170.medium;

public class ShortestWaytoFormString {

      public int shortestWay(String src, String target) {
            int seqCount = 0; // the number of procedures through the source string (or the number of subsequences) required to generate the target string
            int p2 = 0;
            while (p2 < target.length()) {

                  int prev = p2;

                  for (int p1 = 0; p1 < src.length(); p1++) {
                        if (p2 < target.length() && src.charAt(p1) == target.charAt(p2)) {
                              p2++;
                        }
                  }

                  if (prev == p2) {
                        return -1;
                  }
                  
                  seqCount++;
            }
            return seqCount;
      }

      public static void main(String[] args) {

            var solution = new ShortestWaytoFormString();

            System.out.println(solution.shortestWay("abc", "abcbc")); // prints 2
            System.out.println(solution.shortestWay("abc", "acdbc")); // prints -1
            System.out.println(solution.shortestWay("xyz", "xzyxz")); // prints 3
            System.out.println(solution.shortestWay("den", "denendede")); // prints 4
      }
}
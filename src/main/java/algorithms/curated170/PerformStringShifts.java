package algorithms.curated170;

public class PerformStringShifts {
   public String stringShift(String string, int[][] shift) {
    int len = string.length();
    for (int[] move : shift) {
      int direction = move[0];
      int amount = move[1] % len;
      if (direction == 0) {
        // Move necessary amount of characters from front to end 
        string = string.substring(amount) + string.substring(0, amount);
      } else {
        // Move necessary amount of characters from end to front
        string = string.substring(len - amount) + string.substring(0, len - amount);
      }
    }
    return string;
  }
}

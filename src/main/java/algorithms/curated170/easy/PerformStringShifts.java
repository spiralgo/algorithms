package algorithms.curated170.easy;

public class PerformStringShifts {
  public String stringShift(String string, int[][] shift) {

    int[] overallShifts = new int[2];
    countLeftRightShifts(shift, overallShifts);

    int leftShifts = overallShifts[0];
    int rightShifts = overallShifts[1];

    int len = string.length();
    if (leftShifts > rightShifts) {
      leftShifts = (leftShifts - rightShifts) % len;
      string = string.substring(leftShifts) + string.substring(0, leftShifts);
    } else if (rightShifts > leftShifts) {
      rightShifts = (rightShifts - leftShifts) % len;
      string = string.substring(len - rightShifts) + string.substring(0, len - rightShifts);
    }

    return string;
  }

  private void countLeftRightShifts(int[][] shift, int[] overallShifts) {
    for (int[] move : shift) {
      overallShifts[move[0]] += move[1];
    }
  }
  
}

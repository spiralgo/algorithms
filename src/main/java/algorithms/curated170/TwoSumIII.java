package algorithms.curated170;

import java.util.HashMap; 
import java.util.Map;
public class TwoSumIII {

  private HashMap<Integer, Integer> num_counts;

  /** Initialize your data structure here. */
  public TwoSumIII() {
    this.num_counts = new HashMap<Integer, Integer>();
  }

  /** Add the number to an internal data structure.. */
  public void add(int number) {
    if (this.num_counts.containsKey(number))
      this.num_counts.replace(number, this.num_counts.get(number) + 1);
    else
      this.num_counts.put(number, 1);
  }

  /** Find if there exists any pair of numbers which sum is equal to the value. */
  public boolean find(int value) {
    for (Map.Entry<Integer, Integer> entry : this.num_counts.entrySet()) {
      int complement = value - entry.getKey();
      if (complement != entry.getKey()) {
        if (this.num_counts.containsKey(complement))
          return true;
      } else {
        if (entry.getValue() > 1)
          return true;
      }
    }
    return false;
  }
}
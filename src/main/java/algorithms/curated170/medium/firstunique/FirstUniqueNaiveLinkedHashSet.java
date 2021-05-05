package algorithms.curated170.medium.firstunique;

import java.util.LinkedHashSet;
import java.util.HashSet;

public class FirstUniqueNaiveLinkedHashSet {

    HashSet<Integer> uniques = new LinkedHashSet<>();
    HashSet<Integer> allNums = new HashSet<>();

    public FirstUniqueNaiveLinkedHashSet(int[] nums) {
        for (int k : nums) {
            add(k);
        }
    }

    public int showFirstUnique() {
        if (uniques.size() > 0) {
            return uniques.iterator().next();
        }
        return -1;
    }

    public void add(int k) {
        if (!allNums.add(k)) {
            uniques.remove(k);
        } else {
            uniques.add(k);
        }
    }

    public static void main(String[] args) {
        FirstUniqueNaiveLinkedHashSet fu = new FirstUniqueNaiveLinkedHashSet(new int[]{3, 2, 5, 5, 7, 11, -9, 5});
        fu.add(2);
        fu.add(3);
        fu.add(3);
        fu.add(-4);
        fu.add(-1);
        System.out.println(fu.showFirstUnique()); // prints 7
    }
}

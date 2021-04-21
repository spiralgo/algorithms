package algorithms.curated170.medium;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks

{
    public static int connectSticks(int[] lengths) {
        int cost = 0;

        PriorityQueue<Integer> sticks = new PriorityQueue<Integer>();
        for (int l : lengths) {
            sticks.offer(l);
        }
        while (sticks.size() > 1) {
            int newStick = sticks.poll() + sticks.poll(); //PriorityQueue polls the two smallest numbers
            cost += (newStick);
            sticks.offer(newStick); //We add the new connected stick
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] lengths = new int[] { 5, 2, 1, 3, 4, 7, 11 };
        System.out.println(connectSticks(lengths)); // prints 84
    }
}
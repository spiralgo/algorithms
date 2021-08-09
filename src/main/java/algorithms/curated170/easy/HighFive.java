package algorithms.curated170.easy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HighFive {

    public int[][] highFive(int[][] items) {

        HashMap<Integer, PriorityQueue<Integer>> scoresOfId = new HashMap<>();
        heapScoresToStudents(items, scoresOfId);

        int[][] result = new int[scoresOfId.size()][2];
        int i = 0;
        
        for (int id : scoresOfId.keySet()) {
            result[i][0] = id;
            int k = 5;
            int sum = 0;
            PriorityQueue<Integer> heapedScores = scoresOfId.get(id);

            while (!heapedScores.isEmpty() && k-- > 0) {
                sum += heapedScores.poll();
            }
            
            result[i++][1] = sum / 5;
        }

        return result;
    }

    private void heapScoresToStudents(int[][] items, HashMap<Integer, PriorityQueue<Integer>> scoresOfId) {
        for (int[] item : items) {
            if (!scoresOfId.containsKey(item[0])) {
                scoresOfId.put(item[0], new PriorityQueue<>((a, b) -> b - a));
            }
            scoresOfId.get(item[0]).offer(item[1]);
        }
    }

    public static void main(String[] args) {
        HighFive hf = new HighFive();

        int[][] items = new int[][] { new int[] { 1, 91 }, new int[] { 1, 92 }, new int[] { 2, 93 },
                new int[] { 2, 97 }, new int[] { 1, 60 }, new int[] { 2, 77 }, new int[] { 1, 65 }, new int[] { 1, 87 },
                new int[] { 1, 100 }, new int[] { 2, 100 }, new int[] { 2, 76 } };

        int[][] result = hf.highFive(items);

    }
}

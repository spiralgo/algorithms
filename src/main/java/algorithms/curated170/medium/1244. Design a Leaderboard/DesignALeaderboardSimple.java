package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DesignALeaderboardSimple {

    public static class Leaderboard {
        public HashMap<Integer, Integer> leaderboard = new HashMap<>();

        public void addScore(int id, int score) {
            if (leaderboard.get(id) != null) {
                score += leaderboard.get(id);
            }
            leaderboard.put(id, score);
        }

        public int top(int K) {
            ArrayList<Integer> list = new ArrayList<>(leaderboard.values());
            Collections.sort(list, Collections.reverseOrder());
            int total = 0;

            for (int i = 0; i < K; i++) {

                total = total + list.get(i);
            }
            return total;
        }
        public void reset(int playerId) {
            leaderboard.put(playerId, 0);
        }
    }

    public static void main(String[] args) {
        //Testing Leaderboard
        System.out.println("Leaderboard: ");
        var leaderboard1 = new Leaderboard();
        leaderboard1.addScore(1, 94);
        leaderboard1.addScore(1, 45);
        leaderboard1.addScore(2, 95);
        leaderboard1.addScore(3, 96);
        System.out.println(leaderboard1.top(2));
        leaderboard1.reset(1);
        System.out.println(leaderboard1.top(3));
        leaderboard1.addScore(4, 98);
        System.out.println(leaderboard1.top(1));
    }
}
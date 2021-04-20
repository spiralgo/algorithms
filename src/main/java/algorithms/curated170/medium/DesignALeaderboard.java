package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DesignALeaderboard {
    
    public static class Leaderboard {
        List<int[]> leaderboard = new LinkedList<>();

        public void addScore(int id, int score)
        { //binary searching won't work, as we have to delete the previous instance of the id as well
        if(leaderboard.isEmpty())
        {
            leaderboard.add(new int[]{id, score});
            return;
        }
        boolean added = false;
            for(int i = 0; i<leaderboard.size(); i++)
            {
                if(!added && score > leaderboard.get(i)[1])
                {
                    leaderboard.add(i,new int[]{id, score});
                    added = true;
                    continue;
                }
                if(id == leaderboard.get(i)[0])
                {
                    leaderboard.remove(i);
                    i--;
                }
            }
            if(!added)
            {
                leaderboard.add(new int[]{id, score});
            }
        }

        public int top(int K) {
            int sum = 0;
            for(int i = 0; i<K; i++)
            {
                sum += leaderboard.get(i)[1];
            }
            return sum;
        }

        public void reset(int id) {
            for(int i = 0; i<leaderboard.size(); i++)
            {
                if(leaderboard.get(i)[0] == id)
                {
                    leaderboard.remove(i);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        var leaderboard = new Leaderboard();
        leaderboard.addScore(1, 95);
        System.out.println(Arrays.toString(leaderboard.leaderboard.get(0)));
        leaderboard.addScore(2, 45);
        System.out.println(Arrays.deepToString(leaderboard.leaderboard.toArray()));
        leaderboard.addScore(3, 44);
        leaderboard.addScore(4, 96);
        System.out.println(Arrays.deepToString(leaderboard.leaderboard.toArray()));
        leaderboard.addScore(1, 94);
        System.out.println(Arrays.deepToString(leaderboard.leaderboard.toArray()));
        System.out.println(leaderboard.top(3));
        leaderboard.reset(2);
        System.out.println(Arrays.deepToString(leaderboard.leaderboard.toArray()));
    }
}
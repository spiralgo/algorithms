package algorithms;

import java.util.Arrays;
import java.util.Random;

public class PaintHouse {
    static int solution(int[][] costs)
    {
        int h = costs.length; //number of houses
        if(h==0)
        {
            return 0;
        }
        for(int i = 1; i<h;i++)
        {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][2], costs[i-1][0]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(Math.min(costs[h-1][0], costs[h-1][1]), costs[h-1][2]);
    }
    public static void main(String[] args) {
        int[][] costs0 = new int[][]{{1,3,7},{3,4,8},{5,1,11}};
        int[][] costs1 = new int[][]{{17,2,17},{16,16,5},{14,3,9}};
        System.out.println(solution(costs0));
        System.out.println(solution(costs1));

        //Testing for random input:
        int houses = 50;
        int[][] costs = new int[50][3];
        for(int i = 0; i<50;i++)
        {
            costs[i][0] = new Random().nextInt(50);
            costs[i][1] = new Random().nextInt(50);
            costs[i][2] = new Random().nextInt(50);
        }
        System.out.println(Arrays.deepToString(costs));
        System.out.println(solution(costs));
    }
}

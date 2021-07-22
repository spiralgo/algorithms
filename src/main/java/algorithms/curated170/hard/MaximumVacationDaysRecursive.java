package algorithms.curated170.hard;

public class MaximumVacationDaysRecursive {

    private int weekCount;
    private int cities;
    private int[][] memo;

    public int maxVacationDays(int[][] flights, int[][] days) {
        weekCount = days[0].length;
        cities = flights.length;
        memo = new int[cities][weekCount];
        return dfs(flights, days, 0, 0);
    }

    public int dfs(int[][] flights, int[][] days, int currCity, int week) {
        if (week == weekCount) {
            return 0;
        }

        if (memo[currCity][week] != 0) {
            return memo[currCity][week];
        }

        int maxVac = 0;
        for (int c = 0; c < cities; c++) {
            if (flights[currCity][c] == 1 || c == currCity) {
                int vacDays = days[c][week] + dfs(flights, days, c, week + 1);
                maxVac = Math.max(maxVac, vacDays);
            }
        }
        return memo[currCity][week] = maxVac;
    }

    public static void main(String[] args) {

    }
}

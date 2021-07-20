package algorithms.curated170.hard;

public class MaximumVacationDays {

    private static final int CANT_VISIT = -1;

    public int maxVacationDays(int[][] flights, int[][] days) {
        int cities = flights.length;
        int weeks = days[0].length;

        int[] maxDays = new int[cities];

        for (int c = 0; c < cities; c++) {
            if (flights[0][c] == 1) {
                maxDays[c] = days[c][0];
            } else {
                maxDays[c] = CANT_VISIT;
            }
        }
        maxDays[0] = days[0][0];

        for (int w = 1; w < weeks; w++) {
            int[] nextWeekMaxes = new int[cities];

            for (int i = 0; i < cities; i++) {
                if (maxDays[i] != CANT_VISIT) {
                    nextWeekMaxes[i] = maxDays[i] + days[i][w];
                } else {
                    nextWeekMaxes[i] = CANT_VISIT;
                }
            }

            for (int from = 0; from < cities; from++) {
                if (maxDays[from] == CANT_VISIT) {
                    continue;
                }
                for (int to = 0; to < cities; to++) {
                    if (flights[from][to] == 1) {
                        nextWeekMaxes[to] = Math.max(nextWeekMaxes[to], maxDays[from] + days[to][w]);
                    }
                }
            }

            maxDays = nextWeekMaxes;
        }

        int maxVacation = 0;
        for (int vacDays : maxDays) {
            maxVacation = Math.max(maxVacation, vacDays);
        }

        return maxVacation;
    }

    public static void main(String[] args) {

    }
}

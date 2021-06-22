package algorithms.curated170.medium.minimumknightmoves;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumKnightMovesBFS {

    private final int[][] MOVES = new int[][] { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 },
            { 1, -2 }, { 2, -1 } };

    boolean[][] visited;

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        boolean[][] visited = new boolean[304][304];
        visited[1][1] = true;

        Deque<int[]> locations = new ArrayDeque<>();
        locations.add(new int[] { 0, 0 });

        int result = 0;
        while (!locations.isEmpty()) {
            int size = locations.size();
            for (int i = 0; i < size; i++) {
                int[] pos = locations.remove();
                int curX = pos[0];
                int curY = pos[1];
                if (curX == x && curY == y) {
                    return result;
                }

                moveKnightInDirections(locations, curX, curY);
            }
            result++;
        }
        throw null;
    }

    private void moveKnightInDirections(Deque<int[]> q, int curX, int curY) {
        for (int[] dir : MOVES) {
            int newX = curX + dir[0];
            int newY = curY + dir[1];
            if (isInRangeAndNotVisited(newX, newY)) {
                q.add(new int[] { newX, newY });
                visited[newX + 1][newY + 1] = true;
            }
        }
    }

    private boolean isInRangeAndNotVisited(int newX, int newY) {
        return newX >= -1 && newY >= -1 && !visited[newX + 1][newY + 1];
    }

}

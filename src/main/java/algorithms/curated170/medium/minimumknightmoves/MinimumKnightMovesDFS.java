package algorithms.curated170.medium.minimumknightmoves;

public class MinimumKnightMovesDFS {

    int[][] minMoves;

    public int minKnightMoves(int x, int y) {
        minMoves = new int[x + 3][y + 3];

        return DFS(Math.abs(x), Math.abs(y));
    }

    int DFS(int x, int y) {
        if (x + y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        }
        if (minMoves[x][y] != 0) {
            return minMoves[x][y];
        }
        int res = Math.min(DFS(Math.abs(x - 1), Math.abs(y - 2)), DFS(Math.abs(x - 2), Math.abs(y - 1))) + 1;
        minMoves[x][y] = res;
        return res;
    }

}

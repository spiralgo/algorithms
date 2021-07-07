package algorithms.medium.mapofhighestpeak;

import java.util.ArrayDeque;
import java.util.Deque;

public class MapOfHighestPeakBFS {
    int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int[][] heightMap;
    int rows, cols;

    public int[][] highestPeak(int[][] isWater) {
        rows = isWater.length;
        cols = isWater[0].length;
        heightMap = new int[rows][cols];

        Deque<int[]> levelTiles = createInitialLevel(isWater);

        traverseHeightLevels(levelTiles);

        return heightMap;
    }

    private Deque<int[]> createInitialLevel(int[][] isWater) {
        Deque<int[]> levelTiles = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    levelTiles.offer(new int[] { i, j });
                } else {
                    heightMap[i][j] = -1;
                }
            }
        }
        return levelTiles;
    }

    private void traverseHeightLevels(Deque<int[]> levelTiles) {
        int curLevel = 1;
        while (!levelTiles.isEmpty()) {
            int levelSize = levelTiles.size();
            for (int i = 0; i < levelSize; i++) {
                int[] tile = levelTiles.poll();
                int x = tile[0];
                int y = tile[1];
                setAdjacentHeights(levelTiles, x, y, curLevel);
            }
            curLevel++;
        }

    }

    private void setAdjacentHeights(Deque<int[]> levelTiles, int x, int y, int curLevel) {
        for (int[] dir : DIRECTIONS) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (isOutOfMapOrAssigned(nx, ny)) {
                continue;
            }
            heightMap[nx][ny] = curLevel;
            levelTiles.offer(new int[] { nx, ny });
        }
    }

    private boolean isOutOfMapOrAssigned(int nx, int ny) {
        return (nx < 0 || nx >= rows || ny < 0 || ny >= cols || heightMap[nx][ny] != -1);
    }

}

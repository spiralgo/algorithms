package algorithms.curated170.hard;

import java.util.HashSet;
import java.util.Set;

import algorithms.datastructures.Pair;

public class RobotRoomCleaner {

    final static int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        moveRobotBacktrack(0, 0, 0);
    }

    public void moveRobotBacktrack(final int ROW, final int COL, final int DIR) {
        robot.clean();

        for (int i = 0; i < 4; ++i) {
            int NEW_DIR = (DIR + i) % 4;
            int NEW_X = ROW + DIRECTIONS[NEW_DIR][0];
            int NEW_Y = COL + DIRECTIONS[NEW_DIR][1];
            Pair<Integer, Integer> nextTile = new Pair<>(NEW_X, NEW_Y);
            
            if (!visited.contains(nextTile) && robot.move()) {
                visited.add(nextTile);
                moveRobotBacktrack(NEW_X, NEW_Y, NEW_DIR);
                goBack();
            }

            robot.turnRight();
        }
    }

    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    interface Robot {
        public boolean move();

        public void turnLeft();

        public void turnRight();

        public void clean();
    }

}

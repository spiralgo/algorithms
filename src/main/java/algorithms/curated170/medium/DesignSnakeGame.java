package algorithms.curated170.medium;

import java.util.LinkedList;

public class DesignSnakeGame {

    class SnakeGame {

        LinkedList<Point> snake = new LinkedList<>();
        final int[][] FOOD;
        final int WIDTH, HEIGHT;
        int score = 0;
        final int GAME_OVER = -1;

        public SnakeGame(int width, int height, int[][] food) {
            this.FOOD = food;
            this.WIDTH = width;
            this.HEIGHT = height;
            this.snake.add(new Point(0, 0));
        }

        public int move(String DIRECTION) {
            Point oldHead = snake.peekFirst();
            Point newHead = moveHeadToDirection(DIRECTION, oldHead.X, oldHead.Y);

            Point tail = snake.peekLast();
            for (Point p : snake) {
                if (p != tail && newHead.equals(p)) {
                    return GAME_OVER;
                }
            }

            if (snakeInBounds(newHead)) {
                if (snakeEatsFood(newHead)) {
                    score++;
                } else {
                    snake.removeLast();
                }
                snake.addFirst(newHead);
            } else {
                return GAME_OVER;
            }

            return score;

        }

        private boolean snakeEatsFood(Point newHead) {
            return (score < FOOD.length && FOOD[score][0] == newHead.X && FOOD[score][1] == newHead.Y);
        }

        private boolean snakeInBounds(Point newHead) {
            return (0 <= newHead.X && 0 <= newHead.Y && newHead.Y < WIDTH && newHead.X < HEIGHT);
        }

        private Point moveHeadToDirection(final String DIRECTION, final int X, final int Y) {
            switch (DIRECTION) {
                case "R":
                    return new Point(X, Y + 1);
                case "L":
                    return new Point(X, Y - 1);
                case "D":
                    return new Point(X + 1, Y);
                case "U":
                    return new Point(X - 1, Y);
            }
            throw new IllegalArgumentException("The given direction is not valid");
        }

        public class Point {
            final int X;
            final int Y;

            public Point(final int X, int Y) {
                this.X = X;
                this.Y = Y;
            }

            public boolean equals(Point node) {
                return this.X == node.X && this.Y == node.Y;
            }

        }
    }
}

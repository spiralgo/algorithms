public class Solution {
    int[][] maze;
    int[] hole;

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

        this.maze = maze;
        this.hole = hole;
        return dijkstra(ball);
    }

    public String dijkstra(int[] ball) {

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.distance == p2.distance) {
                    return p1.path.compareTo(p2.path);
                } else {
                    return p1.distance - p2.distance;
                }
            }
        });
        int[][] directions = { { 0, -1 }, { 1, 0 }, { -1, 0 }, { 0, 1 } };
        char[] directionSymbols = { 'l', 'd', 'u', 'r' };

        pq.add(new Point(ball[0], ball[1], 0, new StringBuilder("")));

        while (!pq.isEmpty()) {

            Point startPoint = pq.poll();

            int x = startPoint.x;
            int y = startPoint.y;

            if (maze[x][y] == -1) {
                continue;
            }

            maze[x][y] = -1;

            if (isInTHole(x, y)) {
                return startPoint.path.toString();
            }

            for (int i = 0; i < 4; i++) {
                int dirx = directions[i][0];
                int diry = directions[i][1];

                int nextX = x;
                int nextY = y;

                int currentDistance = startPoint.distance;

                while (canPass(nextX, nextY) && !isInTHole(nextX, nextY)) {
                    nextX += dirx;
                    nextY += diry;
                    currentDistance++;
                }

                if (!isInTHole(nextX, nextY)) {
                    nextX -= dirx;
                    nextY -= diry;
                    currentDistance--;
                }

                if (maze[nextX][nextY] != -1) {

                    StringBuilder path = new StringBuilder(startPoint.path);
                    path.append(directionSymbols[i]);

                    pq.add(new Point(nextX, nextY, currentDistance, path));
                }
            }
        }
        return "impossible";
    }

    boolean isInTHole(int x, int y) {
        return (x == hole[0] && y == hole[1]);
    }

    boolean canPass(int nextX, int nextY) {
        return (nextX >= 0 && nextY >= 0 
                && nextX < maze.length && nextY < maze[0].length  
                && maze[nextX][nextY] != 1);
    }

    private class Point {

        private int x, y, distance;
        private StringBuilder path;

        Point(int x, int y, int distance, StringBuilder path) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.path = path;
        }
    }
}

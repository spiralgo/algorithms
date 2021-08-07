package algorithms.curated170.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CampusBikesGaleShapley {

      public Point getClosestPair(Point first, Set<Point> pool) {
            int minDis = Integer.MAX_VALUE;
            Point second = null;

            for (Point p : pool) {
                  int newDis = dist(first, p);
                  if (newDis < minDis) {
                        minDis = newDis;
                        second = p;
                  } else if (newDis == minDis && p.i < second.i) {
                        second = p;
                  }
            }

            return second;
      }

      public int[] assignBikes(int[][] workers, int[][] bikes) {
            int[] results = new int[workers.length];

            Set<Point> workersLeft = new HashSet<>();
            Set<Point> bikesLeft = new HashSet<>();
            
            initializeSets(workers, bikes, workersLeft, bikesLeft);
            
            searchMatchForEachworker(results, workersLeft, bikesLeft);

            return results;
      }

      private void searchMatchForEachworker(int[] results, Set<Point> workersLeft, Set<Point> bikesLeft) {
            Map<Point, Point> calculated = new HashMap<>();

            while (!workersLeft.isEmpty()) {
                  Point curWorker = workersLeft.iterator().next();
                  Point worker = null, bike = null;

                  while (true) {
                        bike = computePair(bikesLeft, calculated, curWorker);

                        worker = computePair(workersLeft, calculated, bike);

                        if (curWorker == worker) {
                              break;
                        } else {
                              curWorker = worker;
                        }
                  }

                  results[worker.i] = bike.i;
                  finishMatchings(workersLeft, bikesLeft, calculated, worker, bike);
            }
      }

      private void initializeSets(int[][] workers, int[][] bikes, Set<Point> workersLeft, Set<Point> bikesLeft) {
            for (int i = 0; i < workers.length; i++)
            workersLeft.add(new Point(workers[i], i));
            for (int i = 0; i < bikes.length; i++)
            bikesLeft.add(new Point(bikes[i], i));
      }

      private Point computePair(Set<Point> secondPool, Map<Point, Point> calculated, Point first) {
            Point second;
            Point temp = calculated.get(first);
            
            if (temp == null || !secondPool.contains(temp)) {
                  second = getClosestPair(first, secondPool);
            } else {
                  second = temp;
            }
            calculated.put(first, second);
            return second;
      }

      private void finishMatchings(Set<Point> workersLeft, Set<Point> bikesLeft, Map<Point, Point> calculated, Point worker,
                  Point bike) {
            workersLeft.remove(worker);
            bikesLeft.remove(bike);
            calculated.remove(worker);
            calculated.remove(bike);
      }

      public int dist(Point a, Point b) {
            return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
      }

      class Point {
            int x;
            int y;
            int i;

            public Point(int[] pos, int idx) {
                  x = pos[0];
                  y = pos[1];
                  i = idx;
            }
      }
}

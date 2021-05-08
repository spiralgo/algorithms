package algorithms.curated170.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ParallelCourses {
    Map<Integer, HashSet<Integer>> courseChiMap;
    Map<Integer, HashSet<Integer>> courseParMap;
    HashSet<Integer> firstCourses = new HashSet<>();

    public int solution(int[][] courses) {
        createMap(courses);
        return sortTopologically();
    }

    private int sortTopologically() {
        Queue<Integer> q = new LinkedList<>();
        q.addAll(firstCourses);
        int totalCourses = courseParMap.size() + firstCourses.size();
        int count = 0;
        int processes = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                if (courseChiMap.containsKey(node)) {
                    for (int k : courseChiMap.get(node)) {
                        courseParMap.get(k).remove(node);
                        if (courseParMap.get(k).size() == 0) {
                            q.offer(k);
                        }
                    }
                }
                count++;
            }
            processes++;
        }
        if (count < totalCourses) {
            return -1;
        }
        return processes;
    }

    private void createMap(int[][] courses) {
        courseParMap = new HashMap<>();
        courseChiMap = new HashMap<>();
        for (int[] pair : courses) {
            int chiCourse = pair[0];
            int parCourse = pair[1];
            if (!courseParMap.containsKey(parCourse)) {
                courseParMap.put(parCourse, new HashSet<>());
                firstCourses.remove(parCourse);
            }
            courseParMap.get(parCourse).add(chiCourse);
            if (!courseParMap.containsKey(chiCourse)) {
                firstCourses.add(chiCourse);
            }
            if (!courseChiMap.containsKey(chiCourse)) {
                courseChiMap.put(chiCourse, new HashSet<>());
            }
            courseChiMap.get(chiCourse).add(parCourse);
        }
    }

    public static void main(String[] args) {
        int[][] courses = new int[][] { { 1, 5 }, { 3, 2 }, { 3, 4 }, { 2, 6 }, { 4, 6 }, { 2, 5 }, { 5, 8 }, { 7, 8 },
                { 6, 9 }, { 7, 10 }, { 6, 8 }, { 8, 10 }, { 9, 10 } };
        var solution = new ParallelCourses();
        System.out.println(solution.solution(courses));

        int[][] loopCourses = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 1 } };
        var solution0 = new ParallelCourses();
        System.out.println(solution0.solution(loopCourses));
    }
}

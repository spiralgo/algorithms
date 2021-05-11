package algorithms.curated170.medium.parallelcourses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCoursesBFS {
    List<List<Integer>> courseChiMap;
    int[] inDegreeMap;
    int numOfCourses;

    public int minimumSemesters(int n, int[][] courses) {
        numOfCourses = n;

        createMap(courses);
        return sortTopologically();
    }

    private int sortTopologically() {
        Queue<Integer> q = new LinkedList<>();
        setFirstCourses(q);

        int count = 0;
        int processes = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int k : courseChiMap.get(node)) {
                    inDegreeMap[k]--;
                    if (inDegreeMap[k] == 0) {
                        q.offer(k);
                    }
                }

                count++;
            }
            processes++;
        }
        if (count < numOfCourses) {
            return -1;
        }
        return processes;
    }

    private void createMap(int[][] courses) {
        inDegreeMap = new int[numOfCourses + 1];
        courseChiMap = new LinkedList<>();
        for (int i = 0; i <= numOfCourses; i++) {
            courseChiMap.add(new ArrayList<>());
        }

        for (int[] pair : courses) {
            int A = pair[0];
            int B = pair[1];

            inDegreeMap[B]++;

            courseChiMap.get(A).add(B);
        }
    }

    private void setFirstCourses(Queue<Integer> q) {
        for (int i = 1; i <= numOfCourses; i++) {
            if (inDegreeMap[i] == 0) {
                q.add(i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] courses = new int[][] { { 1, 5 }, { 3, 2 }, { 3, 4 }, { 2, 6 }, { 4, 6 }, { 2, 5 }, { 5, 8 }, { 7, 8 },
                { 6, 9 }, { 7, 10 }, { 6, 8 }, { 8, 10 }, { 9, 10 } };
        var solution = new ParallelCoursesBFS();
        System.out.println(solution.minimumSemesters(10, courses));
    }
}

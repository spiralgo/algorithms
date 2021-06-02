package algorithms.curated170.medium;

import java.util.PriorityQueue;

public class TheEarliestMomentWhenEveryoneBecomeFriends {

    class Solution {

        int[] parent;
        int[] child;

        public int earliestAcq(int[][] logs, int n) {
            parent = new int[n];
            child = new int[n];

            int id_A, id_B, parent_A, parent_B;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                child[i] = 1;
            }

            PriorityQueue<Log> pq = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);
            for (int i = 0; i < logs.length; i++) {
                pq.add(new Log(logs[i][0], logs[i][1], logs[i][2]));
            }

            Log log;

            while (!pq.isEmpty()) {
                log = pq.poll();
                id_A = log.id_A;
                id_B = log.id_B;
                parent_A = findParent(id_A);
                parent_B = findParent(id_B);
                if (parent_A == parent_B) {
                    continue;
                } else {
                    parent[parent_A] = parent_B;
                    child[parent_B] += child[parent_A];
                    if (child[parent_B] == n) {
                        return log.timestamp;
                    }
                }
            }

            return -1;
        }

        int findParent(int id) {
            while (parent[id] != id) {
                int prevParent = parent[id];
                parent[id] = parent[prevParent];
                id = prevParent;
            }
            return id;
        }

        class Log {

            int timestamp;
            int id_A;
            int id_B;

            Log(int timestamp, int id_A, int id_B) {
                this.timestamp = timestamp;
                this.id_A = id_A;
                this.id_B = id_B;
            }
        }
    }
}

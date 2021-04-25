package algorithms.curated170.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KillProcessBFS {
    public static List<Integer> killProcessBFS(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, HashSet<Integer>> parentChildMap = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int par = ppid.get(i);
            if (par == 0) {
                continue;
            }
            int chi = pid.get(i);
            parentChildMap.putIfAbsent(par, new HashSet<>());
            parentChildMap.get(par).add(chi);
        }

        List<Integer> pTK = new LinkedList<>();
        Queue<Integer> toKill = new LinkedList<>();
        toKill.offer(3);
        while (!toKill.isEmpty()) {
            int killed = toKill.poll();
            pTK.add(killed);
            if (parentChildMap.containsKey(killed)) {
                toKill.addAll(parentChildMap.get(killed));
            }
        }
        return pTK;
    }

    public static void main(String[] args) {
        var pid = List.of(1, 3, 10, 5);
        var ppid = List.of(3, 0, 5, 3);
        var k2 = killProcessBFS(pid, ppid, 3);
        System.out.println(k2);
    }
}

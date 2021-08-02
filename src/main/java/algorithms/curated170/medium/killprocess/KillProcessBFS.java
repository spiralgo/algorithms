package algorithms.curated170.medium.killprocess;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KillProcessBFS {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, HashSet<Integer>> digraph = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int par = ppid.get(i);
            if (par == 0) {
                if (pid.get(i) == kill) {
                    return pid;
                }
                continue;
            }
            int child = pid.get(i);
            digraph.putIfAbsent(par, new HashSet<>());
            digraph.get(par).add(child);
        }

        return bfsProcesses(kill, digraph);
    }

    private List<Integer> bfsProcesses(int kill, HashMap<Integer, HashSet<Integer>> digraph) {
        List<Integer> processesKilled = new LinkedList<>();
        Queue<Integer> toKill = new LinkedList<>();
        toKill.offer(kill);
        while (!toKill.isEmpty()) {
            int killed = toKill.poll();
            processesKilled.add(killed);
            if (digraph.containsKey(killed)) {
                toKill.addAll(digraph.get(killed));
            }
        }

        return processesKilled;
    }

    public static void main(String[] args) {
        var solution = new KillProcessBFS();
        var pid = List.of(1, 3, 10, 5);
        var ppid = List.of(3, 0, 5, 3);
        var k2 = solution.killProcess(pid, ppid, 3);
        System.out.println(k2);
    }
}

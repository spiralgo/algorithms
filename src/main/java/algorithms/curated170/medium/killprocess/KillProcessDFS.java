package algorithms.curated170.medium.killprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KillProcessDFS {
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

        return dfsProcesses(kill, digraph);
    }

    private List<Integer> dfsProcesses(int kill, HashMap<Integer, HashSet<Integer>> digraph) {
        List<Integer> processsesKilled = new ArrayList<>();
        Stack<Integer> nextProcs = new Stack<Integer>();
        nextProcs.push(kill);
        while (!nextProcs.empty()) {
            int currProc = nextProcs.pop();
            processsesKilled.add(currProc);
            if (digraph.containsKey(currProc)) {
                nextProcs.addAll(digraph.get(currProc));
            }
        }

        return processsesKilled;
    }

    public static void main(String[] args) {
        var solution = new KillProcessDFS();
        var pid = List.of(1, 3, 10, 5);
        var ppid = List.of(3, 0, 5, 3);
        var k1 = solution.killProcess(pid, ppid, 3);
        System.out.println(k1);
    }
}

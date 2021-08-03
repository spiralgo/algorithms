package algorithms.curated170.medium.killprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class KillProcessRecursive {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill)
    {
        HashMap<Integer, HashSet<Integer>> digraph = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int par = ppid.get(i);
            if (par == 0) {
                if(pid.get(i) == kill)
                {
                    return pid;
                }
                continue;
            }
            int child = pid.get(i);
            digraph.putIfAbsent(par, new HashSet<>());
            digraph.get(par).add(child);
        }

        List<Integer> processesKilled = new ArrayList<>();
        killProcessAndSuccessors(processesKilled, digraph, kill);
        return processesKilled;
    }
    private void killProcessAndSuccessors(List<Integer> processesKilled, HashMap<Integer, HashSet<Integer>> digraph, int proc)
    {
        processesKilled.add(proc);
        if (digraph.containsKey(proc)) {
            for(int successor : digraph.get(proc))
            {
                killProcessAndSuccessors(processesKilled, digraph, successor);
            }
        }
    }

    public static void main(String[] args) {
        var solution = new KillProcessRecursive();
        var pid = List.of(1, 3, 10, 5);
        var ppid = List.of(3, 0, 5, 3);
        var k3 = solution.killProcess(pid, ppid, 3);
        System.out.println(k3);
    }
}

package algorithms.curated170.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class KillProcessDFS {
    public static List<Integer> killProcessDFS(int[] pid, int[] ppid, int kill) {
        HashMap<Integer, HashSet<Integer>> parentChildMap = new HashMap<>();
        for (int i = 0; i < pid.length; i++) {
            int par = ppid[i];
            if (par == 0) {
                continue;
            }
            int chi = pid[i];
            parentChildMap.putIfAbsent(par, new HashSet<>());
            parentChildMap.get(par).add(chi);
        }

        List<Integer> pTK = new LinkedList<>();
        Stack<Integer> toKill = new Stack<Integer>();
        toKill.push(kill);
        while (!toKill.empty()) {
            int killed = toKill.pop();
            pTK.add(killed);
            if (parentChildMap.containsKey(killed)) {
                toKill.addAll(parentChildMap.get(killed));
            }
        }
        return pTK;
    }

    public static void main(String[] args) {
        int[] pid = { 1, 3, 10, 5 };
        int[] ppid = { 3, 0, 5, 3 };
        var k1 = killProcessDFS(pid, ppid, 3);
        System.out.println(k1);
    }
}

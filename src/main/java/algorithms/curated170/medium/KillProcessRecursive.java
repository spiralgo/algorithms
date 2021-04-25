package algorithms.curated170.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class KillProcessRecursive {
    public static List<Integer> killProcessRecursive(int[] pid, int[] ppid, int kill)
    {
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
        recursiveHelper(pTK, parentChildMap, kill);
        return pTK;
    }
    private static void recursiveHelper(List<Integer> pTK, HashMap<Integer, HashSet<Integer>> parentChildMap, int kill)
    {
        pTK.add(kill);
        if (parentChildMap.containsKey(kill)) {
            for(int toKill : parentChildMap.get(kill))
            {
                recursiveHelper(pTK, parentChildMap, toKill);
            }
        }
    }

    public static void main(String[] args) {
        int[] pid = { 1, 3, 10, 5 };
        int[] ppid = { 3, 0, 5, 3 };
        var k3 = killProcessRecursive(pid, ppid, 3);
        System.out.println(k3);
    }
}

package algorithms.curated170.medium;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {

    Map<String, Integer> files;

    public DesignFileSystem() {
        files = new HashMap<>();
        files.put("", 0);
    }

    public boolean createPath(String path, int value) {

        String parentFolder = path.substring(0, path.lastIndexOf('/'));

        if (!files.containsKey(parentFolder)) {
            return false;
        }
        return files.putIfAbsent(path, value) == null ? false : true;
    }

    public int get(String path) {
        return files.getOrDefault(path, -1);
    }

    public static void main(String[] args) {
        var solution = new DesignFileSystem();
        System.out.println(solution.createPath("/a", 1));
        System.out.println(solution.createPath("/b", 2));
        System.out.println(solution.createPath("/b/c", 3));
        System.out.println(solution.createPath("/d/e", 4));
        // System.out.println(solution.createPath("/b/", 5)); LeetCode does not have
        // such cases
        System.out.println(solution.get("/b/c"));
        System.out.println(solution.get("/a"));
        System.out.println(solution.get("/f"));
    }
}

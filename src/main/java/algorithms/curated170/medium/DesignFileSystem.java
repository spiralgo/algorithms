package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignFileSystem {
 

    Map<List<String>, Integer> files;
    public DesignFileSystem()
    {
        files = new HashMap<>();
        files.put(List.of(""), 0);
    }
    public boolean createPath(String path, int value)
    {
        String[] paths = path.split("/");
        List<String> pathList = Arrays.asList(paths);
        if(pathList.size()>=2 && files.containsKey(pathList.subList(0, pathList.size()-1)))
        {
            files.put(pathList, value);
            return true;
        }
        return false;
    }
    public int get(String path)
    {
        return files.getOrDefault(Arrays.asList(path.split("/")), -1);
    }
 
    public static void main(String[] args) {
        var solution = new DesignFileSystem();
        System.out.println(solution.createPath("/a", 1));
        System.out.println(solution.createPath("/b", 2));
        System.out.println(solution.createPath("/b/c", 3));
        System.out.println(solution.createPath("/d/e", 4));
        System.out.println(solution.get("/b/c"));
        System.out.println(solution.get("/a"));
        System.out.println(solution.get("/f"));
    }
}

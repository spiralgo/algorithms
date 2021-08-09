package algorithms.curated170.medium.designlogstoragesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DesignLogStorageSystemSubmap {

    class LogSystem {
    private TreeMap<String, List<Integer>> map;
    private Map<String, Integer> indexes;
    private String min = "2000:01:01:00:00:00", max = "2017:12:31:23:59:59";

    public LogSystem() {
        map = new TreeMap<>();
        indexes = new HashMap<>();
        indexes.put("Year", 4);
        indexes.put("Month", 7);
        indexes.put("Day", 10);
        indexes.put("Hour", 13);
        indexes.put("Minute", 16);
        indexes.put("Second", 19);
    }
    
    public void put(int id, String timestamp) {
        if (!map.containsKey(timestamp)) {
            map.put(timestamp, new ArrayList<>());
        }
        
        map.get(timestamp).add(id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        
        Map<String, List<Integer>> subMap = getMapWithBoundaries(s, e, gra);
        
        return subMap.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    private Map<String, List<Integer>> getMapWithBoundaries(String s, String e, String gra) {
        Map<String, List<Integer>> subMap = map.subMap(
            s.substring(0, indexes.get(gra)) + min.substring(indexes.get(gra)), true,
            e.substring(0, indexes.get(gra)) + max.substring(indexes.get(gra)), true
        );
        return subMap;
    }
}


    public static void main(String[] args) {
        var solution = new DesignLogStorageSystemSubmap();

        var logSystem = solution.new LogSystem();
        logSystem.put(1, "2017:01:31:23:59:59");
        logSystem.put(2, "2017:02:01:23:59:59");
        logSystem.put(3, "2017:01:31:00:00:00");
        List<Integer> res = logSystem.retrieve("2017:01:30:00:00:00", "2017:02:01:00:00:00", "Hour");

        System.out.println(Arrays.toString(res.toArray()));
    }
}

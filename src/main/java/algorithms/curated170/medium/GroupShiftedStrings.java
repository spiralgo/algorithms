package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        char[] chars = s.toCharArray();
        String key = "";
        char firstChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            int diff = chars[i] - firstChar;
            key += diff < 0 ? diff + 26 : diff;
            key += ",";
        }
        return key;
    }

    public static void main(String[] args) {
        GroupShiftedStrings groupShiftedStrings = new GroupShiftedStrings();
        String key = groupShiftedStrings.getKey("acf");
        System.out.println(key);
    }
}
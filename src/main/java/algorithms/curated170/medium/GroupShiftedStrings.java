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

    public String getKey(String str) {
        int diff = str.charAt(0) - 'a';
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)((chars[i] - diff + 26)%26);
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        GroupShiftedStrings groupShiftedStrings = new GroupShiftedStrings();
        String key = groupShiftedStrings.getKey("acf");
        System.out.println(key);
    }
}
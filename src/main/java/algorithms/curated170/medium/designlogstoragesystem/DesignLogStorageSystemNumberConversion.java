package algorithms.curated170.medium.designlogstoragesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class DesignLogStorageSystemNumberConversion {

    public class LogSystem {

        HashMap<String, Integer> dataOrderIdx = new HashMap<>();
        String[] baseData = new String[] { "1999", "00", "00", "00", "00", "00" };
        TreeMap<Long, Integer> map;

        public LogSystem() {
            dataOrderIdx.put("Year", 0);
            dataOrderIdx.put("Month", 1);
            dataOrderIdx.put("Day", 2);
            dataOrderIdx.put("Hour", 3);
            dataOrderIdx.put("Minute", 4);
            dataOrderIdx.put("Second", 5);
            map = new TreeMap<Long, Integer>();
        }

        public void put(int id, String timestamp) {
            int[] st = Arrays.stream(timestamp.split(":")).mapToInt(Integer::parseInt).toArray();
            map.put(convert(st), id);
        }

        public long convert(int[] st) {
            setMonth(st);
            setDay(st);
            return (st[0] - 1999L) * (31 * 12) * 24 * 60 * 60 + st[1] * 31 * 24 * 60 * 60 + st[2] * 24 * 60 * 60
                    + st[3] * 60 * 60 + st[4] * 60 + st[5];
        }

        private void setDay(int[] st) {
            st[2] = st[2] - (st[2] == 0 ? 0 : 1);
        }

        private void setMonth(int[] st) {
            st[1] = st[1] - (st[1] == 0 ? 0 : 1);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            ArrayList<Integer> ids = new ArrayList<>();
            int[] start = arrangeGranularity(s, gra, false);
            int[] end = arrangeGranularity(e, gra, true);

            long startKey = convert(start);
            long endKey = convert(end);

            for (long key : map.tailMap(startKey).keySet()) {
                if (key >= startKey && key < endKey)
                    ids.add(map.get(key));
            }

            return ids;
        }

        public int[] arrangeGranularity(String s, String gra, boolean end) {

            String[] res = baseData.clone();
            String[] dateStrs = s.split(":");

            for (int i = 0; i <= dataOrderIdx.get(gra); i++) {
                res[i] = dateStrs[i];
            }
            int[] dateNumbers = Arrays.stream(res).mapToInt(Integer::parseInt).toArray();

            if (end)
                dateNumbers[dataOrderIdx.get(gra)]++;

            return dateNumbers;
        }
    }

    public static void main(String[] args) {
        var solution = new DesignLogStorageSystemNumberConversion();

        var logSystem = solution.new LogSystem();
        logSystem.put(1, "2017:01:31:23:59:59");
        logSystem.put(2, "2017:02:01:23:59:59");
        logSystem.put(3, "2017:01:31:00:00:00");
        List<Integer> res = logSystem.retrieve("2017:01:30:00:00:00", "2017:02:01:00:00:00", "Hour");

        System.out.println(Arrays.toString(res.toArray()));
    }
}

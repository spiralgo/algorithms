package algorithms.curated170.medium.encodeanddecodestrings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStringsSlashDelimiter {

    public class Codec {

        public String encode(List<String> strs) {
            StringBuilder encoder = new StringBuilder();
            strs.forEach(s -> encoder.append(s.length()).append('/').append(s));
            return encoder.toString();
        }

        public List<String> decode(String s) {
            List<String> decodedStrs = new ArrayList<String>();
            int strEndPoint = 0;

            while (strEndPoint < s.length()) {
                int stringHeadPoint = s.indexOf('/', strEndPoint);
                int strSize = Integer.valueOf(s.substring(strEndPoint, stringHeadPoint));
                strEndPoint = stringHeadPoint + strSize + 1;
                decodedStrs.add(s.substring(stringHeadPoint + 1, strEndPoint));
            }

            return decodedStrs;
        }
    }

    public static void main(String[] args) {
        var solution = new EncodeAndDecodeStringsSlashDelimiter();
        Codec codec = solution.new Codec();
        String en = codec.encode(List.of("One", "Two", "Three", "Four", "", " ",
                "averylongstringaverylongstringaverylongstringaverylongstring"));
        System.out.println(en);
        System.out.println(codec.decode(en));
    }
}
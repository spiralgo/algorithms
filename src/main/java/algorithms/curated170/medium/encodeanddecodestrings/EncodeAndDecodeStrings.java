package algorithms.curated170.medium.encodeanddecodestrings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    public class Codec {

        public String encode(List<String> strs) {
            StringBuilder encoder = new StringBuilder();
            strs.forEach(s -> encoder.append((char) s.length()).append(s));
            return encoder.toString();
        }

        public List<String> decode(String s) {
            List<String> decodedStrs = new ArrayList<>();
            short i = 0, len;

            while (i < s.length()) {
                len = (short) (s.charAt(i) + i + 1);
                decodedStrs.add(s.substring(i + 1, len));
                i = len;
            }

            return decodedStrs;
        }
    }

    public static void main(String[] args) {
        var solution = new EncodeAndDecodeStrings();
        Codec codec = solution.new Codec();
        String en = codec.encode(List.of("One", "Two", "Three", "Four", "", " ",
                "averylongstringaverylongstringaverylongstringaverylongstring"));
        System.out.println(en);
        System.out.println(codec.decode(en));
    }
}
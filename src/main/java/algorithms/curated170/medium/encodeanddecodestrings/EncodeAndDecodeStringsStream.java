package algorithms.curated170.medium.encodeanddecodestrings;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EncodeAndDecodeStringsStream {

    public class Codec {
        public String encode(List<String> strs) {
            return strs.stream().map(s -> s.replace("#", "##") + " # ").collect(Collectors.joining());
        }

        public List<String> decode(String s) {
            List<String> decodedStrs = Stream.of(s.split(" # ", -1)).map(t -> t.replace("##", "#"))
                    .collect(Collectors.toList());
            decodedStrs.remove(decodedStrs.size() - 1);
            return decodedStrs;
        }
    }
}

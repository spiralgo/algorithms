package algorithms.medium;

public class DecodeString {

    int i = 0;
    char[] data;
    int len;

    String decodeString(String s) {
        i = 0;
        data = s.toCharArray();
        len = data.length;
        return buildDecodedStr().toString();
    }

    StringBuilder buildDecodedStr() {
        StringBuilder result = new StringBuilder();

        while (i < len && data[i] != ']') {
            if (!Character.isDigit(data[i])) {
                result.append(data[i++]);
            }

            else {
                int reps = 0;

                while (i < len && Character.isDigit(data[i])) {
                    reps = reps * 10 + data[i++] - '0';
                }

                i++;
                StringBuilder decodedString = buildDecodedStr();
                i++;

                while (reps-- > 0) {
                    result.append(decodedString);
                }
            }
        }
        return result;
    }
}

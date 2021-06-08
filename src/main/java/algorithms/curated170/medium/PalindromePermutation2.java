package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutation2 {

    public List<String> generatePalindromes(String s) {
        int[] map = new int[128];
        char[] halfString = new char[s.length() / 2];
        char ch = 0;
        if (!canPermutePalindrome(s, map)) {
            return new ArrayList<>();
        }

        int k = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 == 1) {
                ch = (char) i;
            }
            for (int j = 0; j < map[i] / 2; j++) {
                halfString[k++] = (char) i;
            }
        }
        List<String> output = new ArrayList<>();
        permute(halfString, 0, ch, output);
        return output;
    }

    public boolean canPermutePalindrome(String halfString, int[] map) {

        for (int i = 0; i < halfString.length(); i++) {
            map[halfString.charAt(i)]++;
        }

        boolean sawSingle = false;
        for (int key = 0; key < map.length; key++) {
            if (map[key] % 2 == 1) {
                if (sawSingle) {
                    return false;
                }
                sawSingle = true;
            }
        }
        return true;

    }

    void permute(char[] halfString, int leftPointer, char ch, List<String> output) {
        if (leftPointer == halfString.length) {
            output.add(addReverseToItself(new String(halfString), ch));
        } else {
            boolean[] visited = new boolean[128];

            for (int i = leftPointer; i < halfString.length; i++) {
                if (visited[halfString[i]]) {
                    continue;
                }
                visited[halfString[i]] = true;
                swap(halfString, leftPointer, i);
                permute(halfString, leftPointer + 1, ch, output);
                swap(halfString, leftPointer, i);

            }
        }
    }

    String addReverseToItself(String permutedHalfString, char ch) {
        StringBuilder sb = new StringBuilder(permutedHalfString).reverse()
                .append(ch == 0 ? "" : ch)
                .append(permutedHalfString);

        return sb.toString();
    }

    public void swap(char[] s, int leftPointer, int i) {
        char temp = s[leftPointer];
        s[leftPointer] = s[i];
        s[i] = temp;
    }
}

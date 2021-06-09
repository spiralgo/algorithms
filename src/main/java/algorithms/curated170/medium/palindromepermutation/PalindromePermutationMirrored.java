package algorithms.curated170.medium.palindromepermutation;

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutationMirrored {

    final int NUM_OF_CHARS = 128;
    final int ALPHABET_START = 97;
    final int ALPHABET_END = 122;

    char[] stringData;
    int length;
    List<String> palindromes;

    public List<String> generatePalindromes(String s) {
        int[] map = new int[NUM_OF_CHARS];
        length = s.length();
        stringData = new char[length];
        palindromes = new ArrayList<>();

        if (!canPermutePalindrome(s, map)) {
            return new ArrayList<>();
        }

        createInitialString(map);

        permute(0);
        return palindromes;
    }

    private void createInitialString(int[] map) {
        int left = 0;
        int right = length - 1;
        for (char i = ALPHABET_START; i <= ALPHABET_END; i++) {
            if (map[i] == 1) {
                continue;
            }
            for (int j = 0; j < map[i]; j += 2) {
                stringData[left++] = i;
                stringData[right--] = i;
            }
        }
    }

    private void permute(int choiceIndex) {
        if (choiceIndex == length / 2) {
            palindromes.add(new String(stringData));
        } else {
            boolean[] visited = new boolean[NUM_OF_CHARS];

            for (int i = choiceIndex; i < stringData.length / 2; i++) {

                if (visited[stringData[i]]) {
                    continue;
                }
                visited[stringData[i]] = true;

                swap(choiceIndex, i);
                permute(choiceIndex + 1);
                swap(choiceIndex, i);
            }
        }
    }

    private boolean canPermutePalindrome(String s, int[] map) {

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }

        boolean sawSingle = false;
        for (char key = ALPHABET_START; key <= ALPHABET_END; key++) {
            if (map[key] % 2 == 1) {
                if (sawSingle) {
                    return false;
                }
                stringData[length / 2] = key;
                sawSingle = true;
            }
        }
        return true;
    }

    private void swap(int choiceIndex, int i) {
        char swapped1 = stringData[choiceIndex];
        char swapped2 = stringData[i];

        stringData[choiceIndex] = swapped2;
        stringData[i] = swapped1;
        stringData[length - 1 - choiceIndex] = swapped2;
        stringData[length - 1 - i] = swapped1;
    }
}

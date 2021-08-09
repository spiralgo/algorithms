package algorithms.curated170.medium.longestrepeatingsubstring;

import java.util.HashSet;

public class LongestRepeatingSubstringBinarySearch {

  public int longestRepeatingSubstring(String s) {
    int[] nums = new int[s.length()];
    for (int i = 0; i < s.length(); i++)
      nums[i] = s.charAt(i) - 'a';

    int start = 1, end = 1;
    while (end < s.length() && searchByRollingHash(nums, end)) {
      end *= 2;
    }

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (searchByRollingHash(nums, mid)) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return end;
  }

  final long CHARS_SIZE = 26;
  final long MOD = (long) 1 << 32;

  public boolean searchByRollingHash(int[] nums, int L) {
    int n = nums.length;
    if (n <= L)
      return false;

    long h = createInitialHash(nums, L, CHARS_SIZE, MOD);

    HashSet<Long> seen = new HashSet<>();

    seen.add(h);

    long TOTAL_POSSIBLE_STR = countStrOfLength(L);
    for (int i = 1; i < n - L + 1; i++) {
      h = undoHash(nums, TOTAL_POSSIBLE_STR, h, i);
      h = (h + nums[i + L - 1]) % MOD;

      if (seen.contains(h))
        return true;

      seen.add(h);
    }

    return false;
  }

  private long countStrOfLength(int L) {
    long TOTAL_POSSIBLE_STR = 1;
    for (int i = 1; i <= L; i++)
      TOTAL_POSSIBLE_STR = (TOTAL_POSSIBLE_STR * CHARS_SIZE) % MOD;
    return TOTAL_POSSIBLE_STR;
  }

  private long undoHash(int[] nums, long TOTAL_POSSIBLE_STR, long h, int i) {
    h = (h * CHARS_SIZE - nums[i - 1] * TOTAL_POSSIBLE_STR + MOD) % MOD;
    return h;
  }

  private long createInitialHash(int[] nums, int L, long a, long modulus) {
    long h = 0;
    for (int i = 0; i < L; i++) {
      h = (h * a + nums[i]) % modulus;
    }
    return h;
  }

  public static void main(String[] args) {
    var longestRepeatingSubstring = new LongestRepeatingSubstringBinarySearch();
    int result = longestRepeatingSubstring.longestRepeatingSubstring("aaaaaaaaaaaaaaaa");
    System.out.println(result);
  }
}
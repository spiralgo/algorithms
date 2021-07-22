package algorithms.curated170.hard;

public class HandshakesThatDontCross {

    private static long[] cache = new long[501];
    static {
        cache[0] = cache[1] = 1;
    }

    private static final int MOD = (int) 1e9 + 7;

    public int numberOfWays(int n) {
        return (int) catalan(n / 2);
    }

    private long catalan(int n) {
        if (cache[n] != 0) {
            return cache[n];
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + catalan(i) * catalan(n - i - 1)) % MOD;
        }
        return cache[n] = res;
    }

}

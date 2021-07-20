package algorithms.curated170.hard;

public class HandshakesThatDontCrossDP {

    private static final int MOD = (int) 1e9 + 7;

    public int numberOfWays(int n) {
        int k = n / 2;
        long[] catalan = new long[k + 1];
        catalan[0] = catalan[1] = 1;

        for (int i = 2; i <= k; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] = (catalan[i] + catalan[j] * catalan[i - j - 1]) % MOD;
            }

        }

        return (int) catalan[k];
    }

}

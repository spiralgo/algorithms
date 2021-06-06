package algorithms.curated170.medium;

public class FourKeysKeyboardMath {

    final int[] first15Max = new int[] { 0, 1, 2, 3, 4, 5, 6, 9, 12, 16, 20, 27, 36, 48, 64, 81 };

    public int maxA(int N) {
        int quadrupleTimes = N > 15 ? (N - 11) / 5 : 0;
        return getQuadrupledCount(N - 5 * quadrupleTimes, quadrupleTimes);
    }

    private int getQuadrupledCount(int index, int quadrupleTimes) {
        return first15Max[index] << (2 * quadrupleTimes);
    }

    public static void main(String[] args) {
        var solution = new FourKeysKeyboardMath();

        for (int i = 0; i < 50; i++) {
            System.out.println(solution.maxA(i));
        }
    }
}
package algorithms.curated170.medium.fourkeyskeyboard;

public class FourKeysKeyboardDP {

    public int maxA(int N) {
        int[] best = new int[N + 1];

        for (int press = 1; press <= N; press++) {
            best[press] = best[press - 1] + 1;
            if (press > 6) {
                best[press] = Math.max(best[press], best[press - 4] * 3);
                best[press] = Math.max(best[press], best[press - 5] * 4);
                best[press] = Math.max(best[press], best[press - 6] * 5);
            }
        }
        return best[N];
    }

    public static void main(String[] args) {
        var solution = new FourKeysKeyboardDP();

        for (int i = 0; i < 50; i++) {
            System.out.println(solution.maxA(i));
        }

    }
}
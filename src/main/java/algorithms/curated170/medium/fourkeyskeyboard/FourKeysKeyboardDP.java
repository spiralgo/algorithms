package algorithms.curated170.medium;

public class FourKeysKeyboardDP {

    public int maxA(int N) {
        int[] best = new int[N + 1];

        for (int press = 1; press <= N; press++) {
            best[press] = best[press - 1] + 1;
            if (press >= 6) {
                for (int x = press - 6; x < press - 3; x++) {
                    int pasteTimes = press - 1 - x;
                    best[press] = Math.max(best[press], best[x] * pasteTimes);
                }
            }
        }
        return best[N];
    }

    public static void main(String[] args) {
        var solution = new FourKeysKeyboardDP();
        
        for (int i = 0; i < 50; i++) {
            
        }

    }
}
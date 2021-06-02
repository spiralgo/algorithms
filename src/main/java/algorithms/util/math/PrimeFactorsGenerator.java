package algorithms.util.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeFactorsGenerator {

    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> hasFactor = new HashSet<>();
    int limitPrime;

    List<Integer> primes = new ArrayList<>(List.of(2, 3, 5, 7));

    boolean sleeveFilled = false;
    boolean[] sleeve;
    List<Integer> primeFactors = new ArrayList<>();

    int orig;

    public List<Integer> getPrimeFactors(int num) {

        orig = num;
        limitPrime = (int) Math.sqrt(num);
        sleeve = new boolean[limitPrime + 1];
        if (limitPrime < 11) {
            sleeveFilled = true;
        }

        divideAndFindPrimeFactors(num, 0, 1);

        return primeFactors;
    }

    private boolean isPrime(int n) {
        for (int p : primes) {
            if (n % p == 0) {
                return false;
            }
        }
        return sleeveFilled;
    }

    private void divideAndFindPrimeFactors(int n, int ip, int prev) {

        if (prev == orig) {
            return;
        }

        boolean divisible = false;
        int prime = getPrime(ip);
        if (n < 2 || prime <= 0) {
            return;
        }

        divisible = n % prime == 0;

        if (!divisible && isPrime(n)) {
            primeFactors.add(n);
            return;
        }

        if (divisible) {
            primeFactors.add(prime);
            divideAndFindPrimeFactors(n / prime, ip, prev * prime);
        } else {
            primes.set(ip, -1 * prime);
            divideAndFindPrimeFactors(n, ip + 1, prev);
        }
    }

    private int getPrime(int ip) {
        if (primes.size() > ip) {
            return primes.get(ip);
        }

        fillPrimeSleeve();

        return findFirstValidPrime();
    }

    private int findFirstValidPrime() {
        int firstP = -1;
        for (int i = 3; i < sleeve.length; i += 2) {
            if (!sleeve[i]) {
                primes.add(i);
                firstP = firstP < 0 ? i : firstP;
            }
        }
        sleeveFilled = true;
        return firstP;
    }

    private void fillPrimeSleeve() {
        for (int p : primes) {
            p = Math.abs(p);
            if (p == 2) {
                continue;
            }

            if (sleeve[p]) {
                continue;
            }

            for (int i = p; i < sleeve.length; i += p) {
                sleeve[i] = true;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < (1 << 10); i++) {
            System.out.println("Factors of " + i + ": " + new PrimeFactorsGenerator().getPrimeFactors(i));
        }
    }
}
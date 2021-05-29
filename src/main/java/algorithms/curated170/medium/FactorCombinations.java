package algorithms.curated170.medium;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FactorCombinations
{

    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> hasFactor = new HashSet<>();
    int limitPrime;

    List<Integer> primes = new ArrayList<>(List.of(2,3,5,7));
    boolean[] sleeve;
    public List<List<Integer>> solve(int num)
    {
        limitPrime = (int) Math.sqrt(num) + 1 ;
        sleeve = new boolean[limitPrime+1];
        sleeve[0] = true;

        help(num, 0, 1);
        return ans;
    }
    private void help(int n, int ip, int prev)
    {
        int prime = getPrime(ip);
        if(prime*prime > n || hasFactor.contains(n/prime)  || hasFactor.contains(prev*prime))
        {
            return;
        }
        if(n % prime == 0)
        {
            ans.add(List.of(n/prime,prime*prev));
            hasFactor.add(n/prime);
            hasFactor.add(prev*prime);
            help(n/prime, ip, prev*prime);

        }
        help(n, ip+1, prev);
    }

    private int getPrime(int ip)
    {
        if(primes.size() > ip)
        {
            return primes.get(ip);
        }

        for(int p : primes)
        {
            if(p==2)
            {
                continue;
            }
            if(!sleeve[p])
            {
                for(int i = 1; i<(limitPrime+1)/p; i++)
                {
                    sleeve[i*p] = true;
                }
            }
        }
        for(int i = primes.get(primes.size()-1); i<limitPrime+1; i+=2)
        {
            if(!sleeve[i])
            {
                primes.add(i);
                return i;
            }
        }
        return -1;
    }

    private int getPrimeBoundApprox(int n)
    {
        float num = (float) n/2;
        for(int i = 0; i<9; i++)
        {
            num = num - (num*num - n)*0.5f/num;
        }
        return (int) num;
    }
    public static void main(String[] args) {
        var solution = new FactorCombinations();
        System.out.println(solution.getPrimeBoundApprox(8));
    }
}
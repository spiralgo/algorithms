package algorithms.curated170.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.TreeUI;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

public class FactorCombinations
{

    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> hasFactor = new HashSet<>();
    int limitPrime;

    List<Integer> primes = new ArrayList<>(List.of(2,3,5,7));

    boolean sleeveFulled = false;
    boolean[] sleeve;
    List<Integer> primeFactors = new ArrayList<>();


    int orig;

    public List<Integer> generatePrimeFactors(int num)
    {
        orig = num;
        limitPrime = (int) Math.sqrt(num);

        sleeve = new boolean[limitPrime+1];

        if(limitPrime < 11) sleeveFulled = true;
        help(num, 0, 1);

        //System.out.println(Arrays.toString(sleeve));
        return primeFactors;
    }
    
    private boolean isPrime(int n)
    {
        for(int p : primes)
        {
            if(n%p == 0)
            {
                return false;
            }
        }
        return sleeveFulled;
    }
    private void help(int n, int ip, int prev)
    {
        //System.out.println("n: " + n+ " ip: " + ip +" prev: " + prev);
        if(prev == orig)
        {
            return;
        }
        if(isPrime(n))
        {
            primeFactors.add(n);
            return;
        }
        int prime = getPrime(ip);
        if(n<2 || prime <= 0)
        {
            return;
        }
        if(n % prime == 0)
        {
            primeFactors.add(prime);
            help(n/prime, ip, prev*prime);
        }
        else
        {
            primes.set(ip, -1*prime);
            help(n, ip+1, prev);
        }
    }

    private int getPrime(int ip)
    {
        if(primes.size() > ip)
        {
            return primes.get(ip);
        }

        for(int p : primes)
        {
            p = Math.abs(p);
            if(p==2)  
            {
                continue;
            }

            if(sleeve[p])
            {
                continue;
            }

            for(int i = p; i<sleeve.length; i+=p){
                sleeve[i] = true;
            }
        }

        int firstP = -1;
        for(int i = 3; i<sleeve.length; i+=2)
        {
            if(!sleeve[i])
            {
                primes.add(i);
                firstP = firstP < 0 ? i : firstP;
            }
        }
        sleeveFulled = true;
        return firstP;
    }
    
    public static void main(String[] args) {
        var solution = new FactorCombinations();

        for(int i = 0; i< (1<<7); i++)
        {
            System.out.println("Factors of " + i + ": " + new FactorCombinations().generatePrimeFactors(i));
        }
    }
}
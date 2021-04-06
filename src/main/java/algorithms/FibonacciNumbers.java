/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Erdem
 */
public class FibonacciNumbers {
    //Fibonacci sequence is assumed to have the structure:
    //1,1,2,3,5,8,13,21,34,55...
    //where fib(n)=fin(n-1)+fin(n-2)
    //Assuming it is indexed by 0:
    //Then: 3rd Fibonacci number = 3
    
    public static int fibonacciNumber(int n)
    {
        //This method utilizes a kind of memoization and calculates the result in linear time
        //Thereby, it avoids unnecessary duplicate calculations
        if(n<0)
        {
            return -1;
            //This doesn't actually equal -1
            //There is actually a more rigorous definition for a fibonacci number for whole set of complex numbers
            //But that is a mathematical problem, beyond the scope of what this method shows
        }
        int a = 1, b = 0;
        for(int i = 0; i<n; i++)
        {
            int temp = a;
            a = a+b;
            b = temp;
        }
        return a;
    }
    public static int fibonacciNumberRecursive(int n)
    {
        /*This is a recursive method but the time it takes for this to calculate
        the number is exponential. Quite inefficient.*/
        if (n < 2) {
            return 1;
        }
        return fibonacciNumberRecursive(n-1) + fibonacciNumberRecursive(n-2);
    }
    
}

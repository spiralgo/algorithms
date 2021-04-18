/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 *
 * @author Erdem
 */
public class ZeroOneKnapsack {
    
    public static class item
    {
        int value = 0;
        int weight = 0;
        public item(int v, int w)
        {
            value = v;
            weight = w;
        }
    }
    public static void print2x2IntArray(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int solutionNaive(int capacity, item[] items, int n)
    {
        if(capacity == 0 || n == 0)
        {
            return 0;
        }
           if (items[n - 1].weight > capacity)
            return solutionNaive(capacity, items, n - 1);

        else
           {
               return Math.max(items[n-1].value
                       + solutionNaive(capacity - items[n-1].weight, items, n - 1),
                       solutionNaive(capacity, items, n - 1));
           }
    }
    public static int solution1(int capacity, item[] items) 
    {
        /*This method returns the maximum possible value of items that together
        could fit (they have a limiting parameter of weight) into a "knapsack" of a certain capacity */
        
        if(capacity <= 0|| items.length == 0)
        {
            return 0;
        }
        int[][] values = new int[items.length+1][capacity+1];
        for(int i = 0; i<=items.length; i++)
        {
            for(int j = 0; j<=capacity; j++)
            {
                if(i == 0 || j == 0)
                {
                    values[i][j] = 0;
                }
                else if (items[i-1].weight <= j)
                {
                    values[i][j] = Math.max(items[i-1].value + values[i-1][j - items[i-1].weight], values[i-1][j]);
                }
                else
                {
                    values[i][j] = values[i-1][j];
                }
            }
        }
        print2x2IntArray(values);
        return values[items.length][capacity];
    }

    public static int solution0(int capacity, item[] items) 
    {
        //This is space optimized relative to solution1
        //Spatial complexity: O(n)
        /*This method returns the maximum possible value of items that together
        could fit (they have a limiting parameter of weight) into a "knapsack" of a certain capacity */
        
        if(capacity <= 0|| items.length == 0)
        {
            return 0;
        }
        int[] values = new int[capacity+1];
        for(int i = 1; i<=items.length; i++)
        {
            int[] newValues = new int[capacity+1];
            for(int j = 0; j<=capacity; j++)
            {
                if(j == 0)
                {
                    newValues[j] = 0;
                }
                else if (items[i-1].weight <= j)
                {
                    newValues[j] = Math.max(items[i-1].value + values[j - items[i-1].weight], values[j]);
                }
                else
                {
                    newValues[j] = values[j];
                }
            }
            values = newValues;
        }
        return values[capacity];
    }

    public static void main(String[] args) {
   
        var a = new item(5,3);
        var b = new item(3,5);
        var c = new item(2,2);
        var d = new item(7,6);
        var e = new item(11,8);
        var f = new item(4,3);
        int n = solution(10, new item[]{a,b,c,d,e,f});
        System.out.println(n); // Prints 13, which is the sum of the values of the items e and c.
        n = solution1(10, new item[]{a,b,c,d,e,f});
        System.out.println(n); 
        int m = solutionNaive(10, new item[]{a,b,c,d,e,f}, 6);
        System.out.println(m); //Also prints 13 but requires more computation
    }
}

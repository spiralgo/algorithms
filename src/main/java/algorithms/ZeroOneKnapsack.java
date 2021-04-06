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
    public static int solution(int capacity, item[] items) 
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
    public static void main() {
        var a = new item(5,3);
        var b = new item(3,5);
        var c = new item(2,2);
        var d = new item(7,6);
        var e = new item(11,8);
        var f = new item(4,3);
        int n = solution(10, new item[]{a,b,c,d,e,f});
        System.out.println(n); // Prints 13, which is the sum of the values of the items e and c.
    }
}

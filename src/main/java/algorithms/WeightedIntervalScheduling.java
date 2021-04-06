/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Erdem
 */
public class WeightedIntervalScheduling {
    public static class Interval
    {
        public static Interval zero = new Interval(0, 0, 0);
        int start, finish, value;
        public Interval(int s, int f, int v)
        {
            start = s;
            finish = f;
            value = v;
        }
    }
 
    public static int solution(List<Interval> intervals)
    {
        //This method returns the maximum value of intervals that are possible to have together
        //Time complexity = O(n log n): sorting O(n log n), the bottom-up search: O (n log n) (for-loop * binary search)
         int n = intervals.size();
         if(n==1)
        {
            return intervals.get(0).value;
        }
        intervals.sort((i1, i2) -> {
            return i1.finish - i2.finish ; //Sorts intervals according to their finish time
        });
        intervals.add(0, Interval.zero);
       
        int[] maxValues = new int[n+1];
        maxValues[0] = 0;
        for (int i = 1; i <= n; i++) {
            int inclVal = intervals.get(i).value;
            int lastVal = maxValues[binarySearch(intervals, i)]; //value of the last compatible interval, this could also have been searched linearly but the binary search makes it more efficient
            inclVal += lastVal;
            
            maxValues[i] = Math.max(inclVal, maxValues[i-1]);
        }
        
        return maxValues[n];
    }
     static public int binarySearch(List<Interval> intervals, int index)
    {
        int lo = 0, hi = index - 1;
        
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (intervals.get(mid).finish <= intervals.get(index).start)
            {
                if (intervals.get(mid+1).finish <= intervals.get(index).start)
                    lo = mid + 1;
                else
                    return mid;
            }
            else
                hi = mid - 1;
        }
        return 0;
    }
     public static void main() {
        Interval a = new Interval(0, 1, 2);
        Interval b = new Interval(5, 9, 3);
        Interval c = new Interval(2, 5, 5);
        Interval d = new Interval(5, 12, 4);
        Interval e = new Interval(10, 13, 5);
        List<Interval> intervals = new LinkedList<>();
        intervals.add(a);
        intervals.add(b);
        intervals.add(c);
        intervals.add(d);
        intervals.add(e);
        int n = solution(intervals);
        System.out.println(n); //prints 15
    }
}

package algorithms.datastructures;

import algorithms.datastructures.DequeS;

public class ArrayListS<T> extends DequeS<T> {

    public T get(int idx) {
        return (T) data[getIndex(idx, true)];
    }

    public ArrayListS set(int idx, T val) {
        data[getIndex(idx, true)] = val;
        return this;
    }

    public T getAt(int idx) {
        return (T) data[getIndex(idx, false)];
    }

    public ArrayListS setAt(int idx, T val) {
        data[getIndex(idx, false)] = val;
        return this;
    }

    private int getIndex(int idx, boolean checkSize) {
        if (checkSize && idx >= getSize()) {
            throw new IndexOutOfBoundsException();
        }
        if (qIdx <= sIdx || idx < (data.length - qIdx)) {
            return qIdx + idx;
        } else {
            return idx - (data.length - qIdx);
        }
    }

    public static void main(String[] args) {
        var aList = new ArrayListS<Integer>();
        
        System.out.println(aList + " with size: " + aList.getSize()); // [] with size: 0

        aList.push(5).push(10).push(15).offer(18).offer(27).offer(30).offer(35).offer(40);
        System.out.println(aList); // [40, 35, 30, 27, 18, 5, 10, 15]
         
        System.out.println(aList.get(1)); // 35
        System.out.println(aList.get(7)); // 15
        System.out.println(aList.set(0, 9).set(3, 99)); // [9, 35, 30, 99, 18, 5, 10, 15]

        for(int i = 0; i<aList.getSize(); i++)
        {
            System.out.print(aList.getAt(i) + " "); 
        } // 9 35 30 99 18 5 10 15
    }
}

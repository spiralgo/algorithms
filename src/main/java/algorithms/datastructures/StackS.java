package algorithms.datastructures;

import java.util.EmptyStackException;

public class StackS<T> {

    private Object[] data;
    private static final int EXPANSION_SIZE = 2;
    private int idx = -1;

    public StackS() {
        data = new Object[8];
    }

    public StackS(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    public StackS<T> push(T val) {
        if (idx == data.length - 1) {
            expandSize();
        }
        data[++idx] = val;
        return this;
    }

    private void expandSize() {
        Object[] newData = new Object[data.length * EXPANSION_SIZE];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public T pop() {
        if (idx < 0) {
            return null;
        }
        T val = (T) data[idx];
        data[idx--] = null;
        return val;
    }

    public T remove() {
        checkIfEmpty();
        T val = (T) data[idx];
        data[idx--] = null;
        return val;
    }

    public T peek() {
        checkIfEmpty();
        T val = (T) data[idx];
        data[idx] = null;
        return val;
    }

    private void checkIfEmpty() {
        if (idx < 0) {
            throw new EmptyStackException();
        }
    }

    private int getSize() {
        return idx + 1;
    }

    private boolean isEmpty() {
        return idx >= 0;
    }

    private void clear() {
        data = new Object[8];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i <= idx; i++) {
            sb.append(data[i].toString()).append(", ");
        }
        if (idx >= 0) {
            sb.setCharAt(sb.length() - 2, ']');
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var s = new StackS<Integer>();
        s.push(5);
        s.push(10);
        System.out.println(s.pop() + " : " + s.pop());
        s.push(9).push(27).push(81);
        System.out.println(s.toString() + " : " + s.pop());
    }
}

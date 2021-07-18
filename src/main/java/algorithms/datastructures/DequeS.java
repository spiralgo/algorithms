package algorithms.datastructures;

import java.util.EmptyStackException;

public class DequeS<T> {

    protected Object[] data;
    private static final int EXPANSION_SIZE = 2;
    protected int sIdx = -1;
    protected int qIdx = 8;

    public DequeS() {
        data = new Object[8];
    }

    public DequeS(int initialCapacity) {
        data = new Object[initialCapacity];
        qIdx = initialCapacity;
    }

    public DequeS<T> push(T val) {
        if (sIdx == qIdx - 1) {
            expandSize();
        }
        data[++sIdx % data.length] = val;
        if (sIdx == 0 && qIdx == data.length) {
            qIdx = 0;
        }
        return this;
    }

    public DequeS<T> offer(T val) {
        if (qIdx == sIdx + 1) {
            expandSize();
        }
        qIdx = (((qIdx - 1) % data.length) + data.length) % data.length;
        data[((qIdx) + data.length) % data.length] = val;
        if (qIdx == data.length - 1 && sIdx == -1) {
            sIdx = data.length - 1;
        }
        return this;
    }

    private void expandSize() {
        Object[] newData = new Object[data.length * EXPANSION_SIZE];

        for (int i = 0; i <= sIdx; i++) {
            newData[i] = data[i];
        }
        for (int i = 1; i <= data.length - qIdx; i++) {
            newData[newData.length - i] = data[data.length - i];
        }
        qIdx = newData.length - (data.length - qIdx);

        data = newData;
    }

    public T pop() {
        if (sIdx < 0) {
            if (qIdx == 0) {
                qIdx = data.length;
            } else if (qIdx < data.length) {
                sIdx = data.length - 1;
            } else {
                return null;
            }
        }

        T val = (T) data[sIdx];
        data[sIdx--] = null;

        if (qIdx == sIdx + 1) {
            sIdx = -1;
            qIdx = data.length;
        }
        return val;
    }

    public T poll() {
        if (qIdx == data.length) {
            if (sIdx >= 0) {
                qIdx = 0;
            } else {
                return null;
            }
        }
        T val = (T) data[qIdx];
        data[qIdx++] = null;
        if (qIdx == sIdx + 1) {
            sIdx = -1;
            qIdx = data.length;
        }
        return val;
    }

    public T[] popN(final int N) {
        if (getSize() < N) {
            throw new EmptyStackException();
        }

        Object[] popped = new Object[N];
        for (int i = 0; i < N; i++) {
            popped[i] = pop();
        }
        return (T[]) popped;
    }

    public T[] pollN(final int N) {
        if (getSize() < N) {
            throw new EmptyStackException();
        }

        Object[] polled = new Object[N];
        for (int i = 0; i < N; i++) {
            polled[i] = poll();
        }
        return (T[]) polled;
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T val = (T) data[sIdx];
        return val;
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T val = (T) data[qIdx];
        return val;
    }

    public int getSize() {
        if (sIdx >= qIdx) {
            return sIdx - qIdx + 1;
        } else {
            return sIdx + 1 + data.length - qIdx;
        }
    }

    private boolean isEmpty() {
        return sIdx == -1;
    }

    private void clear() {
        data = new Object[8];
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        if (sIdx >= qIdx) {
            for (int i = qIdx; i <= sIdx; i++) {
                sb.append(data[i] != null ? data[i].toString() : "null").append(", ");
            }
        } else {
            for (int i = qIdx; i < data.length; i++) {
                sb.append(data[i] != null ? data[i].toString() : "null").append(", ");
            }
            for (int i = 0; i <= sIdx; i++) {
                sb.append(data[i] != null ? data[i].toString() : "null").append(", ");
            }
        }

        sb.setCharAt(sb.length() - 2, ']');
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        var deq = new DequeS<Integer>();

        System.out.println(deq + " with size: " + deq.getSize()); // [] with size: 0

        deq.push(5).push(10).push(15).offer(20).offer(25).offer(30).offer(35).offer(40);
        System.out.println(deq); // [40, 35, 30, 25, 20, 5, 10, 15]

        deq.popN(7); // pops [15, 10, 5, 20, 25, 30, 35]
        System.out.println(deq + " with size: " + deq.getSize()); // [40] with size: 1
        System.out.println(deq.pop()); // 40

        deq.push(5).push(10).push(15).offer(20).offer(25).offer(30).offer(35).offer(40);
        System.out.println(deq + " with size: " + deq.getSize()); // [40, 35, 30, 25, 20, 5, 10, 15] with size: 8 (same elements again)

        deq.pollN(7); // [40, 35, 30, 25, 20, 5, 10]
        System.out.println(deq.poll()); // 15

        deq.push(5).push(10).push(15).offer(20).offer(25).offer(30).offer(35).offer(40).push(27).offer(36);
        System.out.println(deq + " with size: " + deq.getSize()); // [36, 40, 35, 30, 25, 20, 5, 10, 15, 27] with size: 10
        while (!deq.isEmpty()) {
            System.out.print(deq.poll() + " ");
        } // 36 40 35 30 25 20 5 10 15 27
    }
}

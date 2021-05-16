package algorithms.curated170.easy.movingavarage;

 
public class MovingAverageArray {
class MovingAverage {
    private double total = 0;
    private int size;
    private int[] buffer;
    private int head = 0, tail = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        buffer = new int[size];
    }
    
    public double next(int val) {
        if (tail - head >= size) {
            total -= buffer[head++ % size];
        }
        
        total += val;
        buffer[tail++ % size] = val;
        
        return total / (tail - head);
    }
}
}

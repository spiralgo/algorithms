package algorithms.curated170.easy;


public class ArrayReaderImplementation implements ArrayReader {

    int[] array = {-1,0,3,5,9,12};
    
    @Override
    public int get(int index) {
        if (array.length==0)
            return -1;
        
        if(index > array.length-1){
            return Integer.MAX_VALUE;
        }
        
        return array[index];
    }
    
}

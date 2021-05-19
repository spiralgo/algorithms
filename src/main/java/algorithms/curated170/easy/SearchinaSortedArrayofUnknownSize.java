package algorithms.curated170.easy;

 
public class SearchinaSortedArrayofUnknownSize {
       public int search(ArrayReader reader, int target) {
        int lo = 0, hi = 10000;
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            int val = reader.get(mid);
            if(val < target) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return reader.get(lo) == target ? lo : -1;
    }
}

package algorithms.curated170.easy;
 
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings  {
    public static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> hashMap = new HashMap();
       
        for (int i = 0; i < B.length; ++i){
            hashMap.put(B[i], i);

        }
            
        int[] ans = new int[A.length];
        int t = 0;
      
        for (int x: A){
            ans[t++] = hashMap.get(x);
        }
            
        return ans;
    }
    
    public static void main(String[] args) {
     int[]  A = new int[]{12, 28, 46, 32, 50};
     int[]  B = new int[]{50, 12, 32, 46, 28};
   
     int[]  ans = anagramMappings(A, B);
     
    System.out.println(Arrays.toString(ans));
    }
}
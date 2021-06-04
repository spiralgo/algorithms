package algorithms.curated170.medium;

 
public class PaintFence {
      public int numWays(int n, int k) {
       if(n == 0) return 0;
       if(n == 1) return k;
     
       int same = k;
       int different = k*(k-1);
       
       for(int i = 3; i <=n; i++){
           int previousDifferent = different;
           different = (same + different) * (k-1);
           same = previousDifferent; 
       }
      
       return same + different;
    }
}

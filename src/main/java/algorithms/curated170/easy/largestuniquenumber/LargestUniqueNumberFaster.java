package algorithms.curated170.easy.largestuniquenumber;

 
public class LargestUniqueNumberFaster {
  public int largestUniqueNumber(int[] A) {
        int has [] = new int[1001];
        for(int i=0;i<A.length;i++){
            has[A[i]]+=1;
        }
        int res=-1;
        for(int i=1000;i>=0;i--){
            if(has[i]==1){
                res=i;
                break; 
            }
        }
        return res; 
    }
}

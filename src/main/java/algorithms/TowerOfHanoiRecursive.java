package algorithms;

/**
 *
 * @author ASUS
 */
public class TowerOfHanoiRecursive {
 
   static void solve(char source, char extra, char target, int n){
     
        if(n==1){
            System.out.println("(n==1)Stone "+n+ " moved from " + source + " to " + target);
            
        }else{
        
            solve(source, target, extra , n-1);
            System.out.println("(n>1) Stone "+n+ " moved from " + source + " to " + target);
            solve(extra, source, target, n-1);
   
        }
          
    }
    
    public static void main(String[] args) {
        solve('A', 'B', 'C', 3);
    }
}
 
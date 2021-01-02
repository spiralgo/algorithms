package algorithms;

public class RecursiveIterativeLoops {
      
    static void recursive(int n){
        if(n<0) return;
        
        recursive(n-1);
        System.out.println(n + "");
       
    }
    static void iterative(int n){
        for (int i = 0; i<=n; i++) {
            System.out.println(i + "");
        }
    }
    public static void main(String[] args) {
        iterative(5);
    }
    
}

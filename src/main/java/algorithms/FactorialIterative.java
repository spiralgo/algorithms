package algorithms;
 
public class FactorialIterative {
     static int factorial(int n){
         int result = 1;
         
         for (int i = 1; i < n; i++) {
             result = result * i;
             
         }
         return result;
     }    
     
     public static void main(String[] args) {
         System.out.println(factorial(5));
    }
}

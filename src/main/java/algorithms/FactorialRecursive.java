package algorithms;

/**
 *
 * @author ASUS
 */
public class FactorialRecursive {
    static int factorial(int n){    
  if (n == 0)    
    return 1;    
  else    
    return(factorial(n-1) * n);    
 }    
 public static void main(String args[]){  
 
  int number=5;   
  int fact = factorial(number);   
  System.out.println("Factorial of "+number+" is: "+fact);    
 }  
}

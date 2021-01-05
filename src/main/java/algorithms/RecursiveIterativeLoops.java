package algorithms;

import java.util.Stack;

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
    
    static void withStack(int n){
         
          Stack<Integer> stack = new Stack<Integer>();
         
          while(n>=0){
             stack.add(n);
             n--;
          }
        
          while (!stack.empty()) {
                       System.out.println(stack.pop() + "");
          }
     
    }
    public static void main(String[] args) {
        withStack(5);
    }
    
}

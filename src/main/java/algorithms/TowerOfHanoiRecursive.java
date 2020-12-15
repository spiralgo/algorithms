/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author ASUS
 */
public class TowerOfHanoiRecursive {
   static void solve(char source, char extra, char target, int n){
        if(n==1){
            System.out.println("Stone "+n+ " moved from " + source + " to " + target);
            
        }else{
            solve(source, target, extra , n-1);
            System.out.println("Stone "+n+ " moved from " + source + " to " + target);
            solve(extra, source, target, n-1);
   
        }
          
    }
    
    public static void main(String[] args) {
        solve('A', 'B', 'C', 3);
    }
}
 
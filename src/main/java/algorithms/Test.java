/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Stack;

/**
 *
 * @author ASUS
 */
public class Test {
    public static void main(String[] args) {
         Stack<String> stackStuff = new Stack();
          
         stackStuff.add("kitap");
         stackStuff.add("elbise");
         stackStuff.add("ayna");
         
       
         Stack<String> stackFruit = new Stack();
          
         stackFruit.add("karpuz");
         stackFruit.add("ceviz");
         stackFruit.add("muz");
         
         
         
         Stack<Stack> matryoshka = new Stack();

            matryoshka.add(stackStuff);
            matryoshka.add(stackFruit);
            
            
          Stack<String> stack;
         
          while(!matryoshka.empty()){
             stack = matryoshka.pop();
              
             while(!stack.empty()){
                   String objectName = stack.pop();
                   System.out.println(objectName);
                }
             
         }
         
     } 
}
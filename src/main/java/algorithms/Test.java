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
public class Test {
    public static void main(String[] args) {
        Human ali = new Human();
        ali.name = "Ali";
        
        Human muhammed = ali;
        muhammed.name = "Muhammed";
        
        System.out.println(11 / 10);
        
    }
}

 class Human {
    String name;
    
}

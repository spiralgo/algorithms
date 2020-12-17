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
       
        drawWindow(3, 3);
    } 

    private static void drawWindow(int i, int len) {
        int start = 0;
        int end = 0;
                
        if (len > end - start) {
            
            start = i - (len - 1) / 2;
            end = i + (len) / 2; 
        }
        System.out.println("start:" + start + " , end:" + end);
    }

}
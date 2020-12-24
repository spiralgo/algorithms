package algorithms;

import java.util.Stack;

public class Playground {
    public static void main(String[] args) {
       Stack vp = new Stack();
       
       vp.add("{");
       vp.add("[");
       vp.add("(");
       
       StringBuilder sb = new StringBuilder();
       
       while(!vp.empty()){
           sb.append(vp.pop()).append(", ");     
       }
       
        System.out.println(sb.toString());
    } 
}

 
package algorithms;

public class Test {
    public static void main(String[] args) {
         Insan tufan = new Insan("Tufan");
         Insan  tughan = new Insan("Tughan");

         tughan = tufan;
       
         System.out.println(tughan.name); 

     } 
}


class Insan {

    public Insan(String name) {
     this.name = name;
    }
    
   String name; 
}
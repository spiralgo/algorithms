package algorithms;

public class Human {

 String name;
 String gender;
 int age;
 
 void talk(String thought){
     System.out.println(thought);
 }
 
 String createThought(Human insan){
     String thought = "Merhaba. Benim adim "+ insan.name 
                     + ". Cinsiyetim: " + insan.gender + ". Yasim: " +  insan.age;
     
     return thought;
 }
 public static void main(String[] args) {
      Human adem = new Human();
      adem.name = "Adem";
      adem.gender = "Erkek";
      adem.age = 30;
      
      String thought = adem.createThought(adem);
      adem.talk(thought);
     
      Human havva = new Human();
      
      
      havva.name = "Havva";
      havva.gender = "Kad?n";
      havva.age = 30;
      
      thought = adem.createThought(havva);
      havva.talk(thought);
    
}
    
}

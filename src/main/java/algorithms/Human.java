package algorithms;

public class Human implements InterfaceAnimal {

 String name;
 String gender;
 int age;
 
 Human(){}
 
 Human(String name, String gender, int age){
     this.name = name;
     this.gender = gender;
     this.age = age;
 }
 void talk(String thought){
     System.out.println(thought);
 }
 
 String createThought(Human insan){
     String thought = "Merhaba. Benim adim "+ insan.name 
                     + ". Cinsiyetim: " + insan.gender + ". Yasim: " +  insan.age;
     
     return thought;
 }
  static void createThoughtAndTalk(Human insan){
     String thought = "Merhaba. Benim adim "+ insan.name 
                     + ". Cinsiyetim: " + insan.gender + ". Yasim: " +  insan.age;
     
      System.out.println(thought);
 }
 public static void main(String[] args) {
      Human adem = new Human("Adem", "Erkek", 30);
      Human havva = new Human("Havva", "Kadin", 30);
      Human habil = new Human("Habil", "Erkek", 18);
      Human kabil = new Human("Kabil", "Erkek", 18);
      Human kabile = new Human("Kabile", "Kadin", 18);   
      
      Human[] humanity = new Human[5];
       
      humanity = new Human[] { adem, havva, habil, kabil, kabile};
    
     
        for (int counter = 0; counter < humanity.length; counter++) {
            createThoughtAndTalk(humanity[counter]);
        }
 }
 
 public void reproduce() {
        System.out.println("insan uremesi");
    }
    
}

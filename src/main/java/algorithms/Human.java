package algorithms;

public class Human extends LivingThing {

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
      Animal adem = new Human("Adem", "Erkek", 30);
      Animal havva = new Human("Havva", "Kadin", 30);
      Animal habil = new Human("Habil", "Erkek", 18);
      Animal kabil = new Human("Kabil", "Erkek", 18);
      Animal kabile = new Human("Kabile", "Kadin", 18);   
      
      Animal[] humanity = new Animal[5];
       
      humanity = new Animal[] { adem, havva, habil, kabil, kabile};
    
     
        for (int counter = 0; counter < humanity.length; counter++) {
            Human human = (Human) humanity[counter];
            human.reproduce();
            human.breath();
            createThoughtAndTalk(human);
        }
 }

 String getName(){
     return name;
 }
   
    
}

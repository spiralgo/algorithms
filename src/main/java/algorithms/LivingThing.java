package algorithms;

 
public class LivingThing implements Animal{
 String name;
 String getName(){
     return name;
 }
 void reproduce(){
     System.out.println("I reproduce");
 }

    @Override
    public void breath() {
        System.out.println("I breath");
    }
}

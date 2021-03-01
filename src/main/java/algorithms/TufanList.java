package algorithms;

import java.util.ArrayList;
 

public class TufanList extends ArrayList {
    
    public static int kumbaradakiParaMiktari;
    public String name;
  
    public static void main(String[] args) {
     
     paraBiriktir();
     
 
       
     toplamParayiYaz();
    }
    public static void paraBiriktir(){
        TufanList tfn = new TufanList();
        tfn.name = "Tufan";
        tfn.paraEkle(9);
        
        
        TufanList tuna = new TufanList();
        tuna.name = "Tuna";
        tuna.paraEkle(10);
    }
    public void paraEkle(int eklenenPara){
        System.out.println(name + ", " + eklenenPara + " ekledi.");
        kumbaradakiParaMiktari = kumbaradakiParaMiktari + eklenenPara;
              
    }
    
    public static void toplamParayiYaz(){
        System.out.println("Su an kumbarada:" +  kumbaradakiParaMiktari + " lira var."); 
        
    }
}

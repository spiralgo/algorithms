package algorithms;
 
public class Playground {
 
    public static void main(String[] args) {
 
       Playground playground = new Playground();
       int result = playground.lcm(3, 16);
       
       System.out.println(result);
 
    }
 
    int gcd(int a, int b){
        int result = -1;
        for (int i = 1; i <=a && i <=b; i++) {
            if(a % i ==0 && b % i ==0){
                result = i;
            }
        }
        return result;
    }
    
    int lcm(int a, int b){
       return a*b/gcd(a, b);
    }
}

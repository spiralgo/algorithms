package algorithms;

/**
 *
 * @author tunah
 */
public class GcdLcm { 
 
    public static void main(String[] args) {
       GcdLcm gcdLcm = new GcdLcm();
       int result = gcdLcm.lcm(3, 16);
       
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

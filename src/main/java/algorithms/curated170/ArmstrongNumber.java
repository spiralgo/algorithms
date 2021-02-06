package algorithms.curated170;

public class ArmstrongNumber {
        public int getSumOfKthPowerOfDigits(int N, int k) {
        // `result` stores the result of sum of k'th power of each digit.
       int result = 0;

       // Run until N is not 0
       while(N != 0) {
           // Modulo 10 gives us the last digit
           // Add digit ^ k to the result
           result += Math.pow(N % 10, k);
            // Remove the last digit.
           N = N / 10;
       }
       return result;
    }
    public boolean isArmstrong(int N) {
        // Get length of the number by conveting to string.
        int length = String.valueOf(N).length();

        // Return true if Sum of k'th power of digits equals original number.
        return getSumOfKthPowerOfDigits(N, length) == N;
    }
    
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        boolean result = armstrongNumber.isArmstrong(1);
        
        System.out.println(result);
        
    }
}

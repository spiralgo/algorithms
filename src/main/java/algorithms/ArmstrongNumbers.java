/* Java program to check whether a given number is an Armstrong number */
package algorithms;
import java.util.Scanner;
public class ArmstrongNumbers{

    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number");
        number = sc.nextInt();
        if(isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number!");
        } else {
            System.out.println(number + " is an NOT Armstrong number!");
        }
    }

    public static boolean isArmstrong(int n) {
        int no_of_digits = String.valueOf(n).length();
        int sum = 0;
        int value = n;
        for(int i=1;i<=no_of_digits;i++) {
            int digit = value%10;
            value = value/10;
            sum = sum + (int)Math.pow(digit, no_of_digits);
        }
        return sum == n;
    }

}
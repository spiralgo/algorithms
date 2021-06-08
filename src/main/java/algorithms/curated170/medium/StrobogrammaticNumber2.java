package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumber2 {

    final char[][] reflectives = new char[][]
    {
        {'0','0'},
        {'6','9'},
        {'1','1'},
        {'9','6'},
        {'8','8'}
    };

    char[] numBuilder;

    List<String> numbers;

    public List<String> findStrobogrammatic(int n) {
        numbers = new ArrayList<>();
        numBuilder = new char[n];

        createNum(0, n-1);
        return numbers;
    }

    void createNum(int left, int right)
    {
        if(left==right)
        {
            for(int i = 0; i<5; i+=2)
            {
                numBuilder[left] = reflectives[i][0];
                numbers.add(String.valueOf(numBuilder));
            }
            return;
        }
        else if(left > right)
        {
            numbers.add(String.valueOf(numBuilder));
            return;
        }
        for(char[] pair : reflectives)
        {
            if(left == 0 && pair[0] == '0')
            {
                continue;
            }
            numBuilder[left] = pair[0];
            numBuilder[right] = pair[1];
            createNum(left+1, right-1);
        }
    }

    public static void main(String[] args) {

        System.out.println(new StrobogrammaticNumber2().findStrobogrammatic(5));
    }

}

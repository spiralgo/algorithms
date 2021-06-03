package algorithms.curated170.hard;

import algorithms.curated170.easy.Reader4;
import java.util.Arrays;

public class ReadNCharactersGivenRead4II extends Reader4 {
    int index = 0;
    int length = 0;
    char[] buf4 = new char[4];
    public int read(char[] buf, int n) { 
       
       int copiedChars = 0;  
       while (copiedChars < n) {
       
            if (index == length) {
                length = read4(buf4);
                index = 0;
                if (length == 0) {
                    break;
                }
            }
            
            buf[copiedChars++] = buf4[index++];
        }
    
        return copiedChars;
    }
 
    public static void main(String[] args) {
        ReadNCharactersGivenRead4II readNCharactersGivenRead4II = new ReadNCharactersGivenRead4II();
        char[] buf = new char[19];
        int start = 0;
        start =  readNCharactersGivenRead4II.read(buf, 3);
        System.out.println(Arrays.toString(buf)); 
      
        readNCharactersGivenRead4II.index++;
        Reader4.start += start;
        start = readNCharactersGivenRead4II.read(buf, 3);
        System.out.println(Arrays.toString(buf)); 
        
        readNCharactersGivenRead4II.index++;
        Reader4.start += start;
        start = readNCharactersGivenRead4II.read(buf, 3);
        System.out.println(Arrays.toString(buf)); 
       
    }

}

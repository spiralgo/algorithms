package algorithms.curated170.easy;

public class ReadNCharactersGivenRead4 extends Reader4 {
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
    
    public int read2(char[] buf, int n) {
        int copiedChars = 0;
     
        while(copiedChars < n){
            int length = read4(buf4);
            for(int i=0; i<length && copiedChars < n; i++){
                buf[copiedChars++] = buf4[i];
            }
          
            if(length < 4) break;
        }

        return copiedChars;
    }
    public static void main(String[] args) {
        ReadNCharactersGivenRead4 readNCharactersGivenRead4 = new ReadNCharactersGivenRead4();
        char[] buf = new char[19];
        int total = readNCharactersGivenRead4.read(buf, 18);
        System.out.println(total);
     
    }
}

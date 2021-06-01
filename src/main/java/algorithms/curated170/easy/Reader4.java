package algorithms.curated170.easy;

public class Reader4 {

    String fileData = "TheSpiralWillExpand";
 
    public static int start = 0;
    public int read4(char[] buf) {

     

        char[] tmp = fileData.substring(start, start+3).toCharArray();
        int total = 0;
        for (char c : tmp) {
            buf[total++] = c;
        }
    
        return buf.length;
    }
  
}

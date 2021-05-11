package algorithms;

import java.io.BufferedWriter;
import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
 
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtil {

    public static void write(String text, String path) {
       File f = new File(path);
 
        FileWriter fw;
        try {
            fw = new FileWriter(f.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

package algorithms;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        String string = "thestoryofleetcodeandme";

        int firstIndex = string.indexOf("story");
        int secondIndex = "story".length() + firstIndex - 1;
        System.out.println(firstIndex + ", " + secondIndex);

    }
}

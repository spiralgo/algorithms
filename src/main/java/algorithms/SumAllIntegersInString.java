package algorithms;

public class SumAllIntegersInString {
    public static int sumAllIntsInString0(String str) {
        int sum = 0;
        int currNum = 0;
        int sign = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '-') {
                if (currNum != 0) {
                    sum += currNum * sign;
                    currNum = 0;
                }
                sign = -1;
                continue;
            }
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';
                //currNum = currNum * 10 + Character.getNumericValue(ch);
                continue;
            }
            sum += currNum * sign;
            sign = 1;
            currNum = 0;
        }
        sum += currNum * sign;
        return sum;
    }

    public static void main(String[] args) {
        String str = "8109abcd27";
        System.out.println(sumAllIntsInString0(str)); // 8109 + 27 = 8136
        str = "63mnbv99hgf18";
        System.out.println(sumAllIntsInString0(str)); // 63 + 99 + 18 = 180
        str = "lkjh-0209tyu1040oiuy552";
        System.out.println(sumAllIntsInString0(str)); // -209 + 1040 + 552 = 1383
        str = "abc662-1040asdf";
        System.out.println(sumAllIntsInString0(str)); // 662 - 1040 = -378
    }
}

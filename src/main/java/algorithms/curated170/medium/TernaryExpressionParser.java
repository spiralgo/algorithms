package algorithms.curated170.medium;

import java.util.Deque;
import java.util.LinkedList;

 
public class TernaryExpressionParser {
    
    public static void main(String[] args) {
        TernaryExpressionParser t = new TernaryExpressionParser();
        t.parseTernary("T?2:3");
    }
   
  public String parseTernary(String expression) {
    if (expression == null || expression.length() == 0) return "";
    Deque<Character> stack = new LinkedList<>();

    for (int i = expression.length() - 1; i >= 0; i--) {
        char c = expression.charAt(i);
        if (!stack.isEmpty() && stack.peek() == '?') {

            stack.pop(); //pop '?'
            char first = stack.pop();
            stack.pop(); //pop ':'
            char second = stack.pop();

            if (c == 'T') stack.push(first);
            else stack.push(second);
        } else {
            stack.push(c);
        }
    }

    return String.valueOf(stack.peek());
}
}
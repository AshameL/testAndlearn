package algorithm.leetcode.stack;

import java.util.Stack;

public class No20_括号 {
    public static  boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else{
                if(stack.isEmpty())
                    return false;
                else if (c == ')') {
                    if (stack.pop() != '(')
                        return false;
                } else if (c == '}') {
                    if (stack.pop() != '{')
                        return false;
                } else if (c == ']') {
                    if (stack.pop() != '[')
                        return false;
                }
            }

        }
        if(stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "([)]";
        String s1 = "]";

        System.out.println(isValid(s1));

    }
}

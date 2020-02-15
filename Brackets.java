package com.company;

import java.util.Stack;

public class Brackets {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
           // System.out.println((int)(c));
            if (c == '{' || c == '[' || c == '(') stack.push(c);
            else if(stack.empty()) return false;
            else {
                int closed = (int) c;
                int open = (int) stack.pop();//Character.getNumericValue(stack.pop());
                closed = open == 40 ? closed - 1 : closed - 2;//Character.getNumericValue(c) - 1;
                if (!(closed == open)) {
                    return false;
                }
            }
        }

        if (!stack.empty())return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
        s = "()[]{}";
        System.out.println(isValid(s));
        s = "(]";
        System.out.println(isValid(s));
        s = "]";
        System.out.println(isValid(s));
        s = "[";
        System.out.println(isValid(s));

    }


}

package com.company;

import java.util.Stack;

public class abc {
    public static boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        if (S.length() < 3) return false;
        String abc = "abc";

//        int i = 0;
//        int j = 0;
//        while (i < S.length()) {
//            char ch = S.charAt(i);
//
//
//        }
        while(S.indexOf("abc") >= 0) {
            S = S.replace("abc", "");
        }


        return S.length() == 0;
    }

    public static void main(String[] args) {

    }
}

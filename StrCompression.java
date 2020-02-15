package com.company;

import java.util.Arrays;

public class StrCompression {
    public int compress(char[] chars) {
        int count = 1;
        int k = 0;
        if (chars.length < 2) return chars.length;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            System.out.println(c);
        //    char next = i < chars.length - 1 ? chars[i + 1] : 'd';
            if (i >= chars.length - 1 || chars[i + 1] != c) {
                chars[k++] = c;
                String s = count > 1 ? count + "" : "";
                System.out.println("count " + count);
                for (int j = 0; j < s.length(); j++) {
                    chars[k++] = s.charAt(j);
                }
                count = 1;
            } else {
                count++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        char[] chars = new char[] {'a', 'b','b','b','b'};
        StrCompression s = new StrCompression();
        System.out.println(s.compress(chars));
        System.out.println(Arrays.toString(chars));
        char[] c = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(s.compress(c));
        System.out.println(Arrays.toString(c));
    }
}

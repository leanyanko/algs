package com.company;

import java.util.HashMap;
import java.util.Map;

public class StrPermutations {
    public static boolean isPermut(String s, String sub) {
        Map<String, Integer> msub = new HashMap<String, Integer>();
        for (int i = 0; i < sub.length(); i++) {
         //   if
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "cbabadcbbabbcbabaabccbabc";
        String sub = "abbc";
        System.out.println(isPermut(s, sub));
    }
}

package com.company;

import java.util.HashMap;
import java.util.Map;

public class LongestSub {
    public static int lengthOfLongestSubstring(String s) {
    //    if (s.equals("") || s.equals(" ")) return 0;
        StringBuilder str = new StringBuilder();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (str.indexOf(c + "") == -1) {
                str.append(c);
                System.out.println(str.toString());
            } else {
                int len = str.toString().length();
                max = max < len ? len : max;
                System.out.println(str.toString());
                str.delete(0, str.indexOf(c + "") + 1);
                str.append(c);
            }
        }

        int len = str.toString().length();
        max = max < len ? len : max;

        return max;
    }

    public static void main(String[] args) {
//        String s = "pwwkew";
//        String s = "bbbbb";
        String s = "abcabcbb";
        s = "";
        s = "au";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

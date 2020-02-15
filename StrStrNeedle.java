package com.company;

public class StrStrNeedle {

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return 0;
        int ans = -1;


        return ans;
    }
    public static void main(String[] args) {
        String haystack = "mississipi";
        System.out.println(strStr(haystack, "issip"));
    }
}

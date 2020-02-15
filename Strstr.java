package com.company;

public class Strstr {

    public static int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        if (h < needle.length()) return -1;
        if (n == 0) return 0;

        int ans = -1;

        int i = 0;
        while(i < h) {
            char ch = haystack.charAt(i);
            int j = 0;
            while (i < h && ch == needle.charAt(j)) {
                System.out.println(" inner " + ch);
                if (j == n - 1) return i;
                j++;
                System.out.println(i+j);
                ch = haystack.charAt(i + j);
            }

            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
//        System.out.println(strStr(haystack, "issip"));
//        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("mississippi", "issipi"));
    }
}

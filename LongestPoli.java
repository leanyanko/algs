package com.company;

public class LongestPoli {
//    public static String longestPalindrome(String s) {
//        StringBuilder str = new StringBuilder();
//        int l = 0;
//        int h = s.length() - 1;
//        str.append("~");
//        return longest(s, l, h, str);
//    }

//    public static String longest (String s,  int l, int h, StringBuilder str) {
//        String s1 = "";
//        String s2 = "";
//        char chl = s.charAt(l);
//        char chh = s.charAt(h);
//        System.out.println("l " + chl);
//        System.out.println("h " + chh);
//
//        if ((h - 1 == l || h  - 2 == l || h == l) && s.charAt(h) == s.charAt(l))
//            return str.insert(str.indexOf("~"),s.substring(l, h - l)).toString();
//        else if (s.charAt(h) == s.charAt(l)) {
//            str.insert(str.indexOf("~"),s.substring(l, l) + "~");
//            str.insert(str.indexOf("~"),s.substring(h - 1, l) + "~");
//        }
//        else {
//            str = new StringBuilder();
//        }
//        System.out.println(str.toString());
//        s1= longest(s, l + 1, h, str).toString();
//        s2 = longest(s, l, h - 1, str).toString();
//
//        return s1.length() > s2.length() ? s1 : s2;
//    }

    public static String longestPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);

        String reversed = str.reverse().toString();



        return "";
    }

    private static String common (String s, int l, int r, String prev) {
        if (r == l) return "";
        String substring = s.substring(l, r);
        String reversed = new StringBuilder(substring).reverse().toString();
        String ans = "";
        if (s.indexOf(reversed) ==  l || s.indexOf(reversed) ==  l + 1) ans = substring + reversed;

        return ans;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        s = "cbbd";
        System.out.println(longestPalindrome(s));
        s = "acd";
        System.out.println(longestPalindrome(s));
    }
}

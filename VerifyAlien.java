package com.company;

public class VerifyAlien {
//    public static boolean isAlienSorted(String[] words, String order) {
//
//        for (int i = 0; i < 100; i++) {
//            char ch = words[0].length() > i ? words[0].charAt(i) : order.charAt(0);
//            char tmp = ch;
//            char ch2 = ch;
//            for (int j = 1; j < words.length; j++) {
//                String word = words[j];
//                if (i < word.length()) {
//                    //char ch2 = word.charAt(i);
//                    ch2 = word.charAt(i);
//                    if (order.indexOf(ch) > order.indexOf(ch2)) return false;
//                    ch = ch2;
//                }
//            }
//            if (ch != ch2) return true;
//        }
//        return true;
//    }

    public static boolean isAlienSorted(String[] words, String order) {

        String word1 = words[0];
        for (int i = 1; i < words.length; i++) {
            String word2 = words[i];
        //    System.out.println("compare " + word1 + " and " + word2);
            if (!rightOrder(word1, word2, order)) return false;
            word1 = word2;
        }
        return true;
    }

    private static boolean rightOrder (String word1, String word2, String order) {
        int len = word1.length() > word2.length() ? word2.length() : word1.length();
        for (int i = 0; i < len; i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
        //    System.out.println("-- " + ch1 + " and " + ch2);
            if (order.indexOf(ch1) > order.indexOf(ch2)) return false;
            else if (order.indexOf(ch1) < order.indexOf(ch2)) return true;
        }
        return word1.length() <= word2.length();
    }

    public static void main(String[] args) {
//        String[] words = new String[]{"hello","leetcode"};
//        String alpha = "hlabcdefgijkmnopqrstuvwxyz";

        String[] words = new String[]{"apple","app"};
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(isAlienSorted(words,alpha));
    }
}

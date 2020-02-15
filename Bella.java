package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bella {
    public static  List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<String>();
        if (A.length == 0) return result;

        String first = A[0];

//        List<String> f = new ArrayList<>();
        List<Character> chs = new ArrayList<>();

        for (int i = 0; i < first.length(); i++) {
//            f.add(first.charAt(i) + "");
            chs.add(first.charAt(i));
        }


        for (char c : chs) {
            boolean flag = false;
            for (int i = 1; i < A.length; i++) {
                String word = A[i];
                System.out.println("c: " + c);
                if (word.indexOf(c) >= 0) {
                    word = word.replaceFirst(c+"", "");


                    System.out.println(word);
//                    result.add(c+"");
                    flag = true;
                    System.out.println("true");
                }
                else {
                    flag = false;
                    System.out.println("false");
                    break;
                }
            }
            if (flag) result.add(c+"");
        }

        return result;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"cool","lock","cook"};
        System.out.println(commonChars(A).toString());
        System.out.println("lock".replaceFirst("o", ""));
    }
}

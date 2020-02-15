package com.company;

import java.util.HashMap;
import java.util.Map;

public class DnaStrand {
    public static String makeComplement(String dna) {
        //Your code
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < dna.length(); i++) {
            char ch = ' ';
         switch (dna.charAt(i)) {
             case 'A': ch = 'T';
                       break;
             case 'T': ch = 'A';
                 break;
             case 'G': ch = 'C';
                 break;
             case 'C': ch = 'G';
                 break;
         }
            str.append(ch);
        }
        return str.toString();
    }

    public static int duplicateCount(String text) {
        // Write your code here
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); i++) {
            char key = Character.toLowerCase(text.charAt(i));
            if(map.containsKey(key) && map.get(key) == 0) {
                count ++;
                map.put(key, map.get(key) + 1);
            }
            else map.put(key, 0);//
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "reallyLongStringContainingDuplicatesReturnsThre";
        System.out.println(duplicateCount(s));
    }
}

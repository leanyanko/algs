package com.company;

import java.util.HashMap;
import java.util.Map;

public class Pangram {
    public static boolean check(String sentence){
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < sentence.length(); i++) {
            char key = Character.toLowerCase(sentence.charAt(i));
            if(!map.containsKey(key)) map.put(key, key);
        }

        for (char i = 'a'; i < 'z'; i++){
            if (!map.containsKey(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("The quick brown fox jumps over the lazy dog."));
    }
}

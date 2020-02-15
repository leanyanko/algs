package com.company;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static char firstNotRepeatingCharacter(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int size = s.length();
        char[] arr = new char[size];
        int pointer = size - 1;

        for (int i = size - 1; i >= 0 ; i--) {
            char key = s.charAt(i);
         //   System.out.println(key);
            if (!map.containsKey(key)) {
                map.put(key, 0);
                arr[pointer] = key;
                System.out.println(arr[pointer] + " at " + pointer);
                pointer --;
            }
            else {
                map.put(key, map.get(key) +1);
            }
        }
//        System.out.println("size: " + size);
        pointer ++;
//        System.out.println("pointer: " + pointer);


        System.out.println(map.toString());
        while(pointer < size) {

            char key = arr[pointer];
            System.out.println("pointer: " + pointer);
            System.out.println(key);
            if(map.get(key) == 0)
                return key;
            else {
                System.out.println(key + " is in map" );
            }
            pointer ++;
        }

        return '_';
    }

    public static void main(String[] args) {
	// write your code here
        String s = "xdnxxlvupzuwgigeqjggosgljuhliybkjpibyatofcjbfxwtalc";
        System.out.println(firstNotRepeatingCharacter(s));
    }
}

package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Enc {
    public static boolean isCryptSolution(String[] crypt, char[][] solution) {
        String[] nums = new String[3];
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < solution.length; i++){
            map.put(solution[i][0], solution[i][1]);
        }
        System.out.println(map);
        for (int i = 0; i < crypt.length; i++) {
            nums[i] = "";
            for (int j = 0; j < crypt[i].length(); j++) {
                nums[i] += map.get(crypt[i].charAt(j));
            }
            System.out.println(nums[i]);
            if(nums[i].charAt(0) == '0') return false;
          //  if(nums[i].length() > 10) return false;
        }

        return Long.parseLong(nums[0]) + Long.parseLong(nums[1]) == Long.parseLong(nums[2]) ;
    }

    public static void main(String[] args) {
//        String[] crypt = {"SEND", "MORE", "MONEY"};
//        char[][] solution= {{'O','0'},
//                {'M','1'},
//                {'Y','2'},
//                {'E','5'},
//                {'N','6'},
//                {'D','7'},
//                {'R','8'},
//                {'S','9'}};
//        String[] crypt = {"TEN",
//                "TWO",
//                "ONE"};
//        char[][] solution = {{'O','1'},
//                {'T','0'},
//                {'W','9'},
//        {'E','5'},
//    {'N','4'}};
        String[] crypt = {"AAAAAAAAAAAAAA",
                "BBBBBBBBBBBBBB",
                "CCCCCCCCCCCCCC"};
        char[][] solution = {{'A','1'},
                {'B','2'},
        {'C','3'}};
        System.out.println(isCryptSolution(crypt, solution));
    }
}

package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Reorder {
    public static boolean canReorderDoubled(int[] A) {
        if(A.length < 2) return true;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i]))map.put(A[i], 1);
            else map.put(A[i], map.get(A[i]) + 1);
        }

    //    System.out.println(map.toString());

        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            int num = A[i];
         //   System.out.println(num);

            if(num == 0) {
                if (map.get(num) > 0 && map.get(num) % 2 != 0) return false;
                map.put(num, -1);
            }
            else if(map.containsKey(num * 2) && map.get(num) > 0 && map.get(num*2) > 0) { // && map.get(num*2) > 0

                if (map.get(num) == map.get(num*2)) {
                    map.put(num, -1);
                    map.put(num*2, -1);
                }
                else if (map.get(num) > map.get(num * 2)) {
                    map.put(num, map.get(num) - map.get(num * 2));
                    map.put(num*2, -1);
                }
                else {
                    map.put(num*2, map.get(num * 2) - map.get(num));
                    map.put(num, -1);
                }
            }
        }


        for (int i: map.keySet()) {
            if(map.get(i) > 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] A = new int[]{2,-1,1,4,-2,4}; //false
//        int[] A = new int[]{-6, -3}; //true
        int[] A = new int[]{1,2,1,-8,8,-4,4,-4,2,-2}; //true
//          int[] A = new int[]{1,2,4,8}; //true?
//        int[] A = new int[]{-8,-4,-2,-1,0,0,1,2,4,8}; //true
//        int[] A = new int[]{4,-2,2,-4}; //true
//        int[] A = new int[]{-2,-2,1,-2,-1,2}; //false
//        int[] A = new int[]{10,20,40,80}; //true
//        int[] A = new int[]{1,2,4,16,8,4}; //false
        System.out.println(canReorderDoubled(A));
        //A = {4,-2,2,-4};
    }
}

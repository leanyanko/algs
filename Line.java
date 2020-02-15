package com.company;

import java.util.HashMap;
import java.util.Map;

public class Line {
    public static String Tickets(int[] peopleInLine)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] nominals = new int[] {25, 50};
        int size = peopleInLine.length;

        for (int i = 0; i < size; i++) {
            int current = peopleInLine[i];
            int target = current - 25;
            System.out.println(current);

            if (current > 25) {
                for (int j = nominals.length - 1; j >= 0; j--) {
                    int key = nominals[j];
                    System.out.println("target: " + target);
                    while (key <= target && map.containsKey(key) && map.get(key) > 0) {
                        map.put(key, map.get(key) - 1);
                        target -= key;
                        System.out.println("target: " + target);
                    }
                }
                if (target != 0) return "NO";
            }

            if (map.containsKey(current)) map.put(current, map.get(current) + 1);
            else  map.put(current,  1);
            System.out.println(map);

        }
        return "YES";
    }

    public static void main(String[] args) {
//        System.out.println(Tickets(new int[] {25, 25, 50}));
//        System.out.println(Tickets(new int[] {25, 25, 50, 50, 100}));
//        System.out.println(Tickets(new int[] {25, 25, 25, 25, 25, 25, 25, 50, 50, 50, 100, 100, 100, 100}));
        System.out.println(Tickets(new int[] {25,25,50,100,25,25,25,100,25,25,50,100,25,50,25,100}));
    }
}

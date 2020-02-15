package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Candies {
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < candies.length; i++) {
            int candy = candies[i];
            if (map.containsKey(candy)) map.put(candy, map.get(candy) + 1);
            else map.put(candy, 1);
        }
        System.out.println(map);
        int count = 0;
        int subcount = 0;
        for (int candy : map.keySet()) {
            int amount = map.get(candy);
            if (amount % 2 == 0) count ++;
            else if (amount % 2 == 1 && amount > 2) count++;
            else subcount++;
          //  else count ++;
        }


        System.out.println("--" + count);
        count += subcount/2;

        return count;
    }

    public static void main(String[] args) {
        Candies c = new Candies();
        int[] candies = new int[]{1,1,2,3};

        System.out.println(c.distributeCandies(candies));
    }
}

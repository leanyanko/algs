package com.company;

import java.util.*;

public class Songs {
    public static int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> times = new HashMap<>();

        for (int i = 0; i < time.length; i++) {
            int key = time[i];
            if (times.containsKey(key)) times.put(key, times.get(key) + 1);
            else times.put(key, 1);
        }
        times.put(0, 1);

        int[] t = new int[times.size()];
        int i = 0;
        for (int ts: times.keySet()) {
            t[i++] = ts;
        }
        Arrays.sort(t);

        for (i = 0; i < t.length; i++) {
            for (int j = i + 1; j < t.length; j++) {
                int sum = t[i] + t[j];
                System.out.println("sum " + sum);
                if (t[i] == 0 || t[j] == 0 ) {
                    int num = t[i] == 0 ? times.get(t[j]) : times.get(t[j]);
                    System.out.println("----" + t[i] + "(" + times.get(t[i]) +")" + " + " + t[j] + "(" + times.get(t[j]) +")" + " = " + sum);
                    if (num * 2 % 60 == 0) {
                        if (num > 2) {
                            count += num;
                        }
                        else if (num == 2) count += 1;
                    }
                }

                if ((sum % 60 == 0)) {
                    if (t[i] == 0 || t[j] == 0) {
                        int num = t[i] == 0 ? times.get(t[j]) : times.get(t[j]);
                        if (num > 2) {
                            System.out.println(t[i] + "(" + times.get(t[i]) +")" + " + " + t[j] + "(" + times.get(t[j]) +")" + " = " + sum);
                            count += num;
                        }
                        else if (num == 2) count += 1;
                    }
                    else {
                        int f = times.get(t[i]) * times.get(t[j]) ;
//                        int fact = factorial(f);
//                        int num =
                        System.out.println(t[i] + "(" + times.get(t[i]) +")" + " + " + t[j] + "(" + times.get(t[j]) +")" + " = " + sum + " += " + f);
                        count += f;
                    }
                }
            }
        }

        Arrays.sort(time);
        int subcount = 0;
        for (i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                int sum = time[i] + time[j];
                if ((sum % 60 == 0)) {
                    System.out.println(time[i] +  " + " + time[j]  + " = " + sum );
                    subcount ++;
                }
            }
        }
        System.out.println("sub " + subcount);
        return count;
    }

//    private static int recfact(int start, int n) {
//        int i;
//        if (n <= 16) {
//            int r = start;
//            for (i = start + 1; i < start + n; i++) r *= i;
//            return r;
//        }
//        i = n / 2;
//        return recfact(start, i) * recfact(start + i, n - i);
//    }
//    private static int factorial(int n) { return recfact(1, n); }

    public static int numPairsDivisibleBy602(int[] time) {
        int count = 0;
        Map<Integer, Integer> t = new HashMap<>();

        for (int i = 0; i < time.length; i++) {
            int tmp = time[i] % 60;
            int compliment = (60 - tmp) % 60;

            if (t.containsKey(compliment))
                count += t.get(compliment);

            t.put(tmp, 1 + t.getOrDefault(tmp, 0));
        }
        return count;
    }

    public static  int numPairsDivisibleBy603(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int d = (60 - t % 60) % 60;
            if (count.containsKey(d)) { ans += count.get(d); } // in current HashMap, get the number of songs that if adding t equals to a multiple of 60.
            count.put(t % 60, 1 + count.getOrDefault(t % 60, 0)); // update the number of t % 60.
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] times = new int[]{30,20,150,100,40};
//        System.out.println("count " + numPairsDivisibleBy60(times));
        int[] time = new int[] {60,60,60};
        System.out.println(numPairsDivisibleBy602(time));
//        int[] t = new int[]{418,204,77,278,239,457,284,263,372,279,476,416,360,18};
        int[] t = new int[]{390,281,390,139};
        System.out.println(numPairsDivisibleBy602(t));
//        int i = 171 % 60;
//        System.out.println(i);
//        i = 189 % 60;
//        System.out.println(i);
    }
}

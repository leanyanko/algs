package com.company;

import java.lang.reflect.Array;
import java.util.*;
public class SquaredSums {
    public static String listSquared(long m, long n) {
        List<Long[]> ans =  new ArrayList<Long[]>();


        for (long i = m; i <= n; i++) {
            Long[] check = findSumSquaredDivisors(i);
                if (check[0] != -1) ans.add(check);
        }

        String[] tmp = new String[ans.size()];
        for (int i = 0; i < ans.size(); i ++) {
            tmp[i] = Arrays.toString(ans.get(i));
        }

        return Arrays.toString(tmp);
    }

    private static Long[] findSumSquaredDivisors(long num) {
        Long[] ans = new Long[] {new Long(-1), new Long(-1)};

        long sum = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                sum += i * i;
            }
        }

        long square = (long)Math.sqrt(sum);

        System.out.println("i " + num + ", sum: " + sum + ", square: " + square);

        if (square * square == sum) {
            ans [0] = num;
            ans[1] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(listSquared(42, 250));
    }
}

package com.company.bitwise;

public class Xor {
    /*
    Given two signed integers, write a function that returns true if the signs of given integers are different,
    otherwise false. For example, the function should return true -1 and +100, and
    should return false for -100 and -200.
    The function should not use any of the arithmetic operators.

    The sign bit is 1 in negative numbers, and 0 in positive numbers.
    The XOR of x and y will have the sign bit as 1 iff they have opposite sign.
    In other words, XOR of x and y will be negative number number iff x and y have opposite signs.
     */
    private static boolean sameSign(int x, int y) {
        return (x^y) < 0;
    }


    public static void main(String[] args) {
        System.out.println(sameSign(-1, 100));
        System.out.println(sameSign(-100, -200));
        int m = Integer.parseInt("10", 2);
        int x = Integer.parseInt("0011000110", 2);
        System.out.println((int)(x&m));
        m = Integer.parseInt("100", 2);
        x = Integer.parseInt("0011000100", 2);
        System.out.println((int)(x&m));
        m = Integer.parseInt("1000", 2);
        x = Integer.parseInt("0011000000", 2);
        System.out.println((int)(x&m));
    }
}

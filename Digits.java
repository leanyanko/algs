package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class Digits {

//    public static int[] plusOne(int[] digits) {
////         String num = "";
////         for (int i = 0; i < digits.length; i++)
////             num += digits[i];
//
////         long n = Long.parseLong(num);
////         n++;
////         num = "" + n;
////         int[] d = new int[num.length()];
////         for (int i = 0; i < d.length; i++)
////             d[i] = Character.getNumericValue(num.charAt(i));
////         return d;
//        int len = digits.length;
//        int digit = digits[len - 1] + 1;
//        int reminder = (digit - digit % 10) / 10;
//        LinkedList<Integer> l = new LinkedList<>();
//
//        for (int i = digits.length - 1; i >= 0; i--) {
//            digit = i == digits.length - 1 ? digit++ : digits[i] + reminder;
//            reminder = (digit - digit % 10) / 10;
//            digit = digit % 10;
//            l.add(digit);
//        }
//        if (reminder != 0) l.add(reminder);
//
//        int[] result = new int[l.size()];
//        int i = 0;
//        while (l.size() > 0) {
//            result[i++] = l.remove(l.size() - 1);
//        }
//
//        return result;
//    }

    public static int[] plusOne(int[] digits) {
        int[] tmp = new int[digits.length + 1];
        int carry = 0;
        int digit;
        tmp[0] = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            digit = i == digits.length - 1 ? digits[i] + 1 : digits[i] + carry;
            System.out.println(digit);

            if (digit >= 10) {
                carry = 1;
                digit = digit % 10;
            } else carry = 0;
            digits[i] = digit;
            tmp[i + 1] = digit;
        }
        tmp[0] = carry;

        return tmp[0] == 0 ? digits : tmp;
//        int len = digits.length;
//        int digit = digits[len - 1] + 1;
//        int reminder = (digit - digit % 10) / 10;
//        LinkedList<Integer> l = new LinkedList<>();
//
//        for (int i = digits.length - 1; i >= 0; i--) {
//            digit = i == digits.length - 1 ? digit++ : digits[i] + reminder;
//            reminder = (digit - digit % 10) / 10;
//            digit = digit % 10;
//            l.add(digit);
//        }
//        if (reminder != 0) l.add(reminder);
//
//        int[] result = new int[l.size()];
//        int i = 0;
//        while (l.size() > 0) {
//            result[i++] = l.remove(l.size() - 1);
//        }

//        return result;
    }


    public static void main(String[] args) {
//        int digit = 19;
//        int reminder = (digit - digit % 10) / 10;
//        digit = digit % 10;
//        System.out.println("reminder " + reminder);
//        System.out.println("digit " + digit);
        int[] digits = {1, 2, 3};
        int[] digits2 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
        System.out.println(Arrays.toString(plusOne(digits2)));
    }
}

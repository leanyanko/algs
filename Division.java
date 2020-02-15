package com.company;


import java.util.Arrays;

//Integer.Max_Value = 2,147,483, 647 1111111111
//Long.Max_Value = 9,223,372,036,854,775,807; 1111111111111111111
public class Division {
    public static int smallestRepunitDivByK(int K) {
        String num = "1";

//        int N = Integer.parseInt(num);
//        long Nl = Long.parseLong(num);
//        while (N < Integer.MAX_VALUE) {
//        while (N <= 111111111){
//            if (N % K == 0) return num.length();
//            num +=1;
//            N = Integer.parseInt(num);
//        }
//        long Kl = new Long(K);
//        while (num.length() <= 18){
//            if (Nl % Kl == 0) return num.length();
//            num +=1;
//            Nl = Long.parseLong(num);
//        }


        return -1;
    }

    private static boolean divisible (String num, int K) {
        if (num.length() <= 7 && Integer.parseInt(num) % K == 0) return true;
        int len = num.length();
        String l = "";
        l+= K;
        if (len <= l.length()) return false;

        int groups = len / 3;
        int[] triples = new int[groups + 1];
        int j = 0;
        int sum = 0;
        int rem = len % 3;
        while (rem >= 0) {
            num = "0" + num;
        rem--;
            System.out.println(num);
        }
        for (int i = num.length() - 3; i >=0; i-=3) {
            triples[j++] = Integer.parseInt(num.substring(i, i + 3));
        }
//        System.out.println(Arrays.toString(triples));
        String s = "";

        for (int i = 0; i < triples.length; i++) {
            sum += triples[i];
//            if (sum >= Integer.MAX_VALUE - 1000)
        }
        return false;

    }

    public static void main(String[] args) {
//        System.out.println(smallestRepunitDivByK(1));
//        System.out.println(smallestRepunitDivByK(2));
//        System.out.println(smallestRepunitDivByK(3));
//        System.out.println(smallestRepunitDivByK(17));
//        System.out.println(smallestRepunitDivByK(23));
        System.out.println(divisible("8955795758", 37));
    }
}

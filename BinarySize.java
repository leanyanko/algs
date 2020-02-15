package com.company;

public class BinarySize {
    public static int countBits(int n){
        int numbit = 0;

        int remainder;

        while (n >= 1) {
            remainder = n % 2;
            n = n / 2;

            if (remainder == 1) numbit +=1;
        }
        return numbit;
    }

    private static String toBinary(int n ) {
        String ans = "";
        int numbit = 0;
        int quotient;
        int remainder;

        while (n >= 1) {
            remainder = n % 2;
            n = n / 2;
            ans += remainder;
            if (remainder == 1) numbit +=1;
        }
        String tmp = "";
        for (int i = ans.length() - 1; i >=0; i--) tmp += ans.charAt(i);

        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(countBits(1234));
    }

}

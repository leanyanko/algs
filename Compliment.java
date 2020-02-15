package com.company;

public class Compliment {
    public static int bitwiseComplement(int N) {
        int ans = 0;
        String b = Integer.toString(N,2);
        String compliment = "";
        for (int i = 0; i < b.length(); i++) {
            compliment += b.charAt(i) == '1' ? 0 : 1;
        }
        return Integer.parseInt(compliment, 2);
    }



    public static void main(String[] args) {
//        System.out.println(Integer.toString(7,2));
//        System.out.println(Integer.parseInt("0111", 2));
        System.out.println(bitwiseComplement(10));
    }
}

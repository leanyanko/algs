package com.company;

public class Divisors {
    public static boolean divisorGame(int N) {
        if (N == 2) return true;
        boolean ans = false;
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                count++;
                ans = ans || divisorGame(N - i, 2);
            }
        }
        if (count == 0) return false;
        return ans;
    }

    public static boolean divisorGame(int N, int player) {
        boolean ans = false;
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                count++;
                ans = ans || divisorGame(N - i, player++);
            }
        }
        if (count == 0 && player % 2 != 0) return false;
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(divisorGame(2));
        System.out.println(divisorGame(3));
        System.out.println(divisorGame(4));
    }

}

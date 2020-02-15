package com.company;


// * / + -
public class Clumsy {

    public static int clumbsy(int N) {
        int ans = 0;


        int a = N--;
        int b = N > 0 ? N-- : 1;
        int c = N > 0 ? N-- : 1;
        int d = N > 0 ? N-- : 0;
        ans += a * b / c + d;
        System.out.println(ans);
        System.out.println(a + " * " + b + " / " + c + " + " + d + " - ");
        while ( N > 0) {
            a = N--;
            b = N > 0 ? N-- : 1;
            c = N > 0 ? N-- : 1;
            d = N > 0 ? N-- : 0;

            ans -= a * b / c;
            ans += d;

            System.out.println(a + " * " + b + " / " + c + " + " + d + " - ");
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(clumbsy(2));
    }
}


//  10 == 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1


//  15 == 15 * 14 / 13 + 12 - 11 * 10 / 9 + 8 - 7 * 6 / 5 + 4 - 3 * 2 / 1
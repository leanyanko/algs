package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Competition {
    public static int minHours (int N, int P, int[] S) {
        int avg = 0;
        for (int i = 0; i < S.length; i++)
            avg += S[i];
        avg /= S.length;


        for (int i = 0; i < S.length; i++) {

        }
        return 0;
    }
    public static void main(String [] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            String s = in.nextLine();
            int numCases = Integer.parseInt(s);
            for (int a = 0; a < numCases; a++) {

                s = in.nextLine();
                String[] s_ = s.split(" ");
                int N = Integer.parseInt(s_[0]);
                int P = Integer.parseInt(s_[1]);
                int[] S = new int[N];
                s = in.nextLine();
                System.out.println(s);
                s_ = s.split(" ");
                for (int i = 0; i < s_.length - 1; i++) {
                    S[i] = Integer.parseInt(s_[i]);
                }
                System.out.println();
//                while (in.hasNext()) {
//                    String ss = in.nextLine();
//                    System.out.println("wrg");
//                }
//                String ss = in.nextLine();
//                    System.out.println(s);
//                in.close();
                System.out.println("#" + (a + 1) + ": " + minHours(N, P, S));
                System.out.println("");
            }
            String m = in.nextLine();
        System.out.println("m" + m);

    }
}

/*
3
4 3
3 1 9 100
6 2
5 5 1 2 3 4
5 5
7 7 1 7 7
*/
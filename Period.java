package com.company;

public class Period {
    public static int periodicSequence(int s0, int a, int b, int m) {
        int s[] = new int[10];
        //  int i = 5;
        //
        //  s[i] = (a*s[i-1] + b) mod m;
        //
        int i = 1;
        s[0] = s0;
        while (true) {
            if (i > s.length - 3) s = resize(s);
            System.out.println("len " + s.length);
            System.out.println("i " + i);
            s[i] = (a*s[i-1] + b) % m;
            System.out.println("s[i]" + s[i]);
            int T = existsT(s[i], s, i);
            if (T > 0) return T;
            i++;
        }
    }

    public static int[] resize(int[] s) {
        int[] newS = new int [s.length*2];

        for (int i = 0; i < s.length; i++) {
            newS[i] = s[i];
        }

        return newS;
    }

    public static int existsT(int sI, int[] s, int j) {
        for (int i = 0; i < j; i++) {
            if(s[i] == sI) return j - i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int s0 = 11, a = 2, b = 6,  m = 12;
        System.out.println(periodicSequence(s0, a, b, m));
    }

}

package com.company;

import java.util.List;

public class Zig {


    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        // Your Code
        int ans = 0;

        for (int i = 0; i < binary.size(); i++) {
            ans += binary.get(i) * Math.pow(2,i);
        }
        return ans;
    }


    public static int zigzag2(int[] a) {
        int flag = 0;
        int preflag = -1 * flag;
        int len = 1;
        int prevlen = len;

        for (int i = 0; i < a.length - 1; i++) {

            preflag = flag;
            if (a[i] < a [i + 1] ) flag = 1;
            else if (a[i] > a [i+ 1]) flag = -1;
            else flag = 0;

            if ((preflag == (flag * -1) || preflag == 0 )&& flag != 0 ) len ++;
            else {
                prevlen = len > prevlen ? len : prevlen;
                if (flag != preflag || flag ==0) len = 1;
                else len = 2;
            }
        }
        return len > prevlen ? len : prevlen;
    }


    public static int zigzag(int[] a) {
        int test = a[0] - a[1];
        int flag = 0;
        if (test > 0) flag = -1;
        else if (test < 0)flag = 1;
        else flag = 0;
//        int flag = 1;
        int preflag = -1 * flag;
        int len = 1;
        int prevlen = len;

        for (int i = 0; i < a.length - 1; i++) {
            System.out.println("i = " + i + ", elem: " + a[i]);

            preflag = flag;

            if (a[i] < a [i + 1] ) flag = 1;
            else if (a[i] > a [i+ 1]) flag = -1;
            else flag = 0;
            System.out.println("preflag " + preflag + ", flag " + flag);

            if ((preflag == (flag * -1) || preflag == 0 )&& flag != 0 ){ //|| preflag == 0 && flag != 0){
                len ++;
                System.out.println("len " + len);
            }
            else {
                prevlen = len > prevlen ? len : prevlen;
                if (flag != preflag || flag ==0) {len = 1;}
                else { len = 2;}
                preflag = 0;
                System.out.println("CUT: " + len);
            }


        }

        return len > prevlen ? len : prevlen;
    }

    public static void main(String[] args) {
     //   int[] a = {9, 8, 8, 5, 3, 5, 3, 2, 8, 6};
        int[] a = {1,1,1,1};
        System.out.println("len: " + zigzag(a));
    }
}

package com.company;

import java.util.Arrays;

public class SortRoot {
    public static int[] digitRootSort(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            b[i] = 0;
            while(num >= 1) {
                b[i] += num % 10;
                num /= 10;
            }
        }

        quicksort(a, b, 0, b.length - 1);

        int point = 0;
        int end_point = 0;
        for (int i = 1; i < b.length; i++) {
           // point = i;

            if (b[i - 1] != b[i]) {
                System.out.println("point " + point);
                System.out.println("end " + end_point);
                quicksort(b, a, point, end_point);
                point = i;
                end_point = i;
            }
            else {
                end_point++;
            }
        }
        quicksort(b, a, point, end_point);

        return a;
    }
    private static void exch(int[] a, int[] b, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
        swap = b[i];
        b[i] = b[j];
        b[j] = swap;
    }

    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }

    private static int partition(int[] a, int[] b, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = b[lo];
        while (true) {
            while (b[++i] < v) {
                if (i == hi) break;
            }

            while (v < b[--j]) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            if (i >= j) break;

            exch(a, b, i, j);
        }
        exch(a, b, lo, j);

        return j;
    }

    private static void quicksort (int[]a, int[]b, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, b, lo, hi);
        quicksort(a, b, lo, j - 1);
        quicksort(a, b, j + 1, hi);
       // assert isSorted(b, lo, hi);
    }

    public static void main(String[] args) {
        //int[] a = {13, 20, 7, 4};
        int[] a = {100, 22, 4, 11, 31, 103};
        System.out.println(Arrays.toString(digitRootSort(a)));
    }
}

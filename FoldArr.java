package com.company;

import java.util.Arrays;

public class FoldArr {
    public static int[] foldArray(int[] array, int runs)
    {
        int size = array.length;
        int nSize = size % 2 == 0 ? size / 2 : size / 2 + 1;
        if (size < 2 || runs == 0) return array;
        int[] nArr = new int[nSize];

        for (int i = 0; i < nSize; i++) {

            nArr[i] = (i < size - i - 1) ? array[i] + array[size - i - 1] : array[i];
            System.out.println("i " + i + ", nArr[i] " + nArr[i] + " = " + array[i] + " + " + array[size - i - 1]);
        }

        return foldArray(nArr, runs - 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(foldArray(new int[] { 1, 2, 3, 4, 5 }, 1)));
        System.out.println(Arrays.toString(foldArray(new int[] { -9, 9, -8, 8, 66, 23 }, 1)));
        System.out.println(Arrays.toString(foldArray(new int[] { 15 }, 1)));
    }
}

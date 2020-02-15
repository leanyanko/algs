package com.company;

import java.util.Arrays;

public class GreatestSum {

    public static int sum (int[] A, int K) {
        int sum = 0;

        for (int i = 0; i < A.length; i++) {

            sum+=A[i];
        }

        Arrays.sort(A);

        System.out.println(Arrays.toString(A));
        int i = 0;
        while (K > 0) {
            if ( i > A.length || A[i] > 0) {
                Arrays.sort(A);
                i = 0;
            }

            if (A[i] == 0) return sum;

            int negat = A[i];
            A[i++] = -1 * negat;
            sum -= 2 * negat;
            K--;
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[] A = new int[]{4, 2, 3};
//        int[] A = new int[]{3, -1, 0, 2};
        int[] A = new int[]{-2,9,9,8,4};
        System.out.println(sum(A, 5));
    }
}

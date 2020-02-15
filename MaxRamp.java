package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxRamp {
//    public static int maxWidthRamp(int[] A) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < A.length; i++) {
//            map.put(i, i);
//            for (int j = i + 1; j < A.length; j++) {
//                if (A[i] <= A[j]) map.put(i, j);
//            }
//        }
//
//        int[] arr = new int[map.size()];
//        int i = 0;
//        for (int j: map.keySet()) {
//            arr[i++] = map.get(j) - j;
//        }
//
//        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        return arr[arr.length - 1];
//    }

//    public static int maxWidthRamp(int[] A) {
//        int ans = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//
//        int previous = A[0];
//        for (int i = 1; i < A.length; i++) {
//
//        }
//
//        return ans;
//    }
public static int maxWidthRamp(int[] A) {
    int lo = 0;
    int hi = A.length;
    int max = 0;

    while (lo < hi) {
        int mid = (hi - lo) / 2 + lo;

    }
//    for (int i = 0; i < A.length; i++) {
//        for (int j = i + 1; j < A.length; j++) {
//            if (A[i] <= A[j] && j - i > max) max = j - i;
//            }
//        }

    return max;
}

    public static int maxIndexDiff(int A[])
    {
        int maxDiff;
        int i, j;
        int n = A.length;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        LMin[0] = A[0];
        for (i = 1; i < n; i++)
            LMin[i] = min(A[i], LMin[i - 1]);
        System.out.println(Arrays.toString(LMin));

        RMax[n - 1] = A[n - 1];
        for (j = n - 2; j >= 0; j--)
            RMax[j] = max(A[j], RMax[j + 1]);
        System.out.println(Arrays.toString(RMax));

        i = 0; j = 0;
        int max = -1;
        while (j < n && i < n)
        {
            if (LMin[i] <= RMax[j])
            {
                max = max(max, j - i);
                j++;
            }
            else
                i++;
        }

        return max;
    }

    private static int max (int a, int b) {
        return a >= b ? a : b;
    }

    private static int min (int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{6,0,8,2,1,5};
//        int[] arr = new int[]{9,8,1,0,1,9,4,0,4,1};
        int [] arr = new int[]{3,1,2,4};
    //    System.out.println(maxWidthRamp(arr));
        System.out.println(maxIndexDiff(arr));
    }
}

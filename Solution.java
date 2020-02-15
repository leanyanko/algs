package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static int largestK (int N, int L[], int R[]) {
        String [] input = new String[L.length];
        Set<Integer> map = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            map.add(i);
        }

        for (int i = 0; i < L.length; i++) {
//            input[i] = "" + (R[i] - L[i]) + " " + i + " " + L[i] + " " + R[i];
            input[i] = "" + (R[i] - L[i]) + " " + i;
        }

        Arrays.sort(input);
        Set<Integer> set = new HashSet<>();
//        System.out.println(Arrays.toString(input));
        for (int i = 0; i < input.length; i++) {
            String [] data = input[i].split(" ");
            int i_ = Integer.parseInt(data[1]);
            int count = 0;
            for (int j = L[i_]; j <= R[i_]; j++) {
//                System.out.println("assigning from " + L[i_] + " to " + R[i_] );
                if (map.contains(j)) {
                    map.remove(j);
                    count ++;
                }
            }
//            System.out.println("count " + count);
            set.add(count);
        }

//        System.out.println("set " + set);

        int min = N;
        for (int i : set) {
            if (i < min) min = i;
        }

        return min;
    }
    public static void main(String [] args) {
        try {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = in.nextInt();
            for (int a = 0; a < numCases; a++) {
                int N = in.nextInt();
                int Q = in.nextInt();
//            System.out.println("N: " + N + ", Q " + Q);
                int []L = new int[Q];
                int []R = new int[Q];
                for (int i = 0; i < Q; i++) {
                    L[i] = in.nextInt();
                    R[i] = in.nextInt();
                }
                    System.out.println("Case #" + (a + 1) + ": " + largestK(N,L, R));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}

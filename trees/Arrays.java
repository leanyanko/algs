package com.company.trees;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = new int[9];
        arr[1] = 2;
        arr[0] = 1;
        arr[2] = 3;
        for (int i = 3; i < 9; i++) {
            arr[i] = i;
        }
    }
}

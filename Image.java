package com.company;

import java.util.Arrays;

public class Image {
    static int[][] rotateImage(int[][] a) {
        int[][] image = new int[a.length][a[0].length];
        int sizex = a.length - 1;
        int sizey = a[0].length - 1;

        for (int i = 0; i < sizex + 1; i++) {
            for (int j = 0; j < sizey - i; j++) {
             //   System.out.println("i: " + i + " J: " + j);
                int tmp = a[i][j];
                a[i][j] = a[sizey-j][sizex - i];
                a[sizey-j][sizex - i] = tmp;

                System.out.println(tmp + " goes to " +  (sizey-j)  + ", " +(sizex - i) );
            }
        }

        for (int i = 0; i < sizex + 1; i++) {
            for (int j = 0; j < sizey /2 + 1; j++) {
                //   System.out.println("i: " + i + " J: " + j);
                int tmp = a[j][i];
                a[j][i] = a[sizey - j][i];
                a[sizey - j][i] = tmp;

                System.out.println(i + ", " + j+ ": " + tmp + " goes to " +  (sizey - j)  + ", " +(i) );
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for(int i = 0; i < a[0].length; i++)
            System.out.println(Arrays.toString(a[i]));

        System.out.println();
        int b[][] = rotateImage(a);

        for(int i = 0; i < b[0].length; i++)
            System.out.println(Arrays.toString(b[i]));
    }
}

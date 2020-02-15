package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveRows {
    public static int[][] constructSubmatrix2(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {

        int xM = matrix[0].length;
        int yM = matrix.length;
        System.out.println("xM: " + xM);
        System.out.println("yM: " + yM);
        int sizex = xM - columnsToDelete.length;
        int sizey = yM - rowsToDelete.length;
        System.out.println("sizex " + sizex + ", sizey " + sizey );
        int[][] nMat = new int[sizex][sizey];

        int xpointer = 0;
        int ypointer = 0;

        Map <Integer, Integer> maprows = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapcols = new HashMap<Integer, Integer>();
        for (int i = 0; i < columnsToDelete.length; i ++) {
            mapcols.put(columnsToDelete[i], columnsToDelete[i]);
        }
        for (int i = 0; i < rowsToDelete.length; i ++) {
            maprows.put(rowsToDelete[i], rowsToDelete[i]);
        }

        for (int y = 0; y < yM; y++) {
            for (int x = 0; x < xM; x++) {
                System.out.println("x " + x + ", y " + y + " matrix[y][x] " + matrix[y][x]);
                if (!maprows.containsKey(y) && !mapcols.containsKey(x)) {
                    System.out.println(matrix[y][x] + " goes to: " + "xp " + xpointer + ", yp " + ypointer);
                    nMat[xpointer][ypointer] = matrix[y][x];
                    System.out.print(nMat[xpointer][ypointer] + " ");
                    if( xpointer == sizex - 1 ) {
                        ypointer ++;
                        System.out.println("go to row " + ypointer);
                      //  System.out.println();
                        xpointer = 0;
                    }
                    else {
                        xpointer++;
                    }
                }
            }
        }
        return nMat;
    }

    public static int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {

        int xM = matrix[0].length;
        int yM = matrix.length;
        System.out.println("xM: " + xM);
        System.out.println("yM: " + yM);
        int sizey = xM - columnsToDelete.length;
        int sizex = yM - rowsToDelete.length;
        System.out.println("sizex " + sizex + ", sizey " + sizey );
        int[][] nMat = new int[sizex][sizey];

        int xpointer = 0;
        int ypointer = 0;

        Map <Integer, Integer> maprows = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapcols = new HashMap<Integer, Integer>();
        for (int i = 0; i < columnsToDelete.length; i ++) {
            mapcols.put(columnsToDelete[i], columnsToDelete[i]);
        }
        for (int i = 0; i < rowsToDelete.length; i ++) {
            maprows.put(rowsToDelete[i], rowsToDelete[i]);
        }

        for (int y = 0; y < yM; y++) {
            for (int x = 0; x < xM; x++) {
                System.out.println("x " + x + ", y " + y + " matrix[y][x] " + matrix[y][x]);
                if (!maprows.containsKey(y) && !mapcols.containsKey(x)) {
                    System.out.println(matrix[y][x] + " goes to: " + "xp " + xpointer + ", yp " + ypointer);
                    nMat[xpointer][ypointer] = matrix[y][x];
                    System.out.print(nMat[xpointer][ypointer] + " ");
                    if( ypointer == sizey - 1 ) {
                        xpointer ++;
                        System.out.println("go to row " + xpointer);
                        //  System.out.println();
                        ypointer = 0;
                    }
                    else {
                        ypointer++;
                    }
                }
            }
        }
        return nMat;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,0,0},
//                {0,5,0},
//                 {0,0,3}};

//        int[][] matrix = {{1,2,3, 4},
//                {5,6,7, 8},
//                {9,10,11, 12}};
//        int [] rowsToDelete = {1};
//        int [] columnsToDelete = {0};

        int [][] matrix= {{0,1,2,3},
                          {4,5,6,7},
                          {8,9,10,11}};

        int[] rowsToDelete = {1};
        int[] columnsToDelete = {0, 2};
        int[][] ans = constructSubmatrix(matrix, rowsToDelete, columnsToDelete);
        System.out.println("ans: ");
        for (int i = 0; i < ans.length; i++) {
           // System.out.println(Arrays.toString(ans[i]));
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}


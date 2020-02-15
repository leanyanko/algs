package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NumOfIslands {
    public static int numIslands(char[][] grid) {
        int islands = 0;
        if (grid.length == 0) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands ++;
                    visit(grid, i, j);
                }
            }
        }

        return islands;
    }


    private static void visit (char[][] grid, int i, int j) {
        if (grid[i][j] == '2') return;
        grid[i][j] = '2';

        if (j > 0 && grid[i][j - 1] == '1') visit(grid, i, j - 1);
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') visit(grid, i, j + 1);
        if (i > 0 && grid[i - 1][j] == '1') visit(grid, i - 1,j);
        if (i < grid.length - 1 && grid[i + 1][j] == '1') visit(grid,i + 1,j);

//        int min_i = i == 0 ? i : i - 1;
//        int max_i = i == grid.length - 1 ? i : i + 1;
//        int min_j = j == 0 ? j : j - 1;
//        int max_j = j == grid[0].length - 1 ? j : j + 1;
//
//          if (grid[i][min_j] == '1') visit(grid, i, min_j);
//          if (grid[i][max_j] == '1') visit(grid, i, max_j);
//          if (grid[min_i][j] == '1') visit(grid, min_i,j);
//          if (grid[max_i][j] == '1') visit(grid,max_i,j);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));

        char[][] grid2 = {{'0','0','0','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                          {'0','0','0','0','0'}};
        System.out.println(numIslands(grid2));

        char[][] grid3 = {};
        System.out.println(numIslands(grid3));

        char[][] grid4 = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}};
        System.out.println(numIslands(grid4));


        for (int i = 0; i < grid4.length; i++) {
        //    for (int j = 0; j < grid[0].length; j++) {
                System.out.println(Arrays.toString(grid4[i]));
        //    }
        }
    }

    //
//        for (int k = min_i; k <= max_i; k++) {
//            for (int m = min_j; m <= max_j; m++) {
//               //    System.out.println(k + ", " + m);
//                if (k == i && m == j || k - 1 == i && m - 1 == j || ) {}
//
//                else if(grid[k][m] == '1') visit(grid, k, m);
//            }
//        }

    //    private static char[][] visit (char[][] grid, int i, int j) {
//        grid[i][j] = '2';
//        int min_i = i == 0 ? i : i - 1;
//        int max_i = i == grid.length - 1 ? i : i + 1;
//        int min_j = j == 0 ? j : j - 1;
//        int max_j = j == grid[0].length - 1 ? j : j + 1;
//
//        for (int k = min_i; k < max_i; k++) {
//            for (int m = min_j; m < max_j; m++) {
//                //   System.out.println(k + ", " + m);
//                if (k == i && m == j) break;
//                if(grid[k][m] == '1') grid = visit(grid, k, m);
//                else break;
//            }
//        }
//
//        return grid;
//    }

    private static boolean isIceland (char[][] grid, boolean[][] visited, int i, int j) {
        if (grid[i][j] == '0') return false;

        visit(grid, visited, i, j);
    //    if (i > 0 && j > 0 && i < grid.length && j < grid[0].length) visit
    //    if (i > 0 && j > 0)


        return true;
    }

    private static void visit (char[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        int min_i = i == 0 ? i : i - 1;
        int max_i = i == grid.length - 1 ? i : i + 1;
        int min_j = j == 0 ? j : j - 1;
        int max_j = j == grid[0].length - 1 ? j : j + 1;

        for (int k = min_i; k < max_i; k++) {
            for (int m = min_j; m < max_j; m++) {
             //   System.out.println(k + ", " + m);
                if (k == i && m == j) break;
                if(grid[k][m] == '1') visit(grid, visited, k, m);
                else break;
            }
        }
    }
}

package com.company;

import java.util.Arrays;

public class RottenOranges {
    public static int orangesRotting(int[][] grid) {
        int mins = -1;

        boolean flag = true;
        int clock = 0;

        int x = grid.length;
        int y = grid[0].length;

        int unvisited = 0;
        boolean[][] visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 0) visited[i][j] = true;
                else {
                    visited[i][j] = false;
                    if(grid[i][j] == 1) unvisited++;
                }
            }
        }
        System.out.println(unvisited);

        while (flag) {

            for (int i = 0; i < x; i++) {
                boolean subflag_r = false;
                boolean subflag_t = false;
                boolean subflag_b = false;
                boolean subflag_l = false;
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == 2) {
                        if (i - 1 > 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 2;
                            visited[i - 1][j] = true;
                            unvisited--;
                            subflag_l = true;
                        }
                        if (i + 1 < x && grid[i + 1][j] ==1) {
                            grid[i + 1][j] = 2;
                            visited[i + 1][j] = true;
                            unvisited--;
                            subflag_r = true;
                        }
                        if (j - 1 > 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 2;
                            visited[i][j - 1] = true;
                            unvisited--;
                            subflag_b = true;
                        }
                        if (j + 1 < y && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 2;
                            visited[i][j + 1] = true;
                            unvisited--;
                            subflag_t = true;
                        }
                    }
                    flag = subflag_b || subflag_l || subflag_r || subflag_t;
                }

                clock++;
            }
//            flag = false;
        }

        System.out.println(unvisited);
        for (int i = 0; i < x; i++)
        System.out.println(Arrays.toString(grid[i]));
        return unvisited == 0 ? clock : -1;
    }

//    private static boolean connected (int[][] grid) {
//        int x = grid.length;
//        int y = grid[0].length;
//        int count = 0;
//
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//                if (grid[i][j] > 0) count++;
//            }
//        }
//
////        boolean visited
//
//    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}

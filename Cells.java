package com.company;

import java.util.Arrays;

public class Cells {
    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] tmp = new int[8];
        tmp[0] = tmp[7] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 7; j++) {
                if (cells[j - 1] == cells[j + 1]) tmp[j] = 1;
                else tmp[j] = 0;
            }
            for (int j = 1; j < 8; j++) {
                cells[j] = tmp[j];
            }
            System.out.println(Arrays.toString(cells));
        }

        return cells;
    }

    public static void main(String[] args) {
        int [] cells = new int[] {0,1,0,1,1,0,0,1};
        int N = 7;
        System.out.println(Arrays.toString(prisonAfterNDays(cells, N)));
    }
}

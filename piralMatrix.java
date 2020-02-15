package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class piralMatrix {
    public List<Integer> spiralOrder2(int[][] matrix) {
        int lpointer = 0;
        int rpointer = matrix.length - 1;
        int tpointer = 0;
        int bpointer = matrix[0].length - 1;

        List<Integer> row = new ArrayList<>();

        int dir_x = 1;
        int dir_y = 1;
        int side = 1;

        while(rpointer > lpointer || tpointer < bpointer) {
            int x = dir_x > 0 ? lpointer : rpointer;
            int y = dir_y > 0 ? tpointer : bpointer;

            if (side % 2 == 0) { //go vertical
                if(dir_x > 0) { // go right - works
                    System.out.println("go right");
                    while(x < rpointer) {
                        int item = matrix[x][y];
                        row.add(item);
                        System.out.println("item " + item);
                        x++;
                    }
                //    lpointer++;
                    tpointer++;
                } else {
                    System.out.println("go left");
                    while(x > lpointer) { //go left
                        int item = matrix[x][y];
                        System.out.println("item " + item);
                        row.add(item);
                        x--;
                    }
                 //   rpointer--;
                    bpointer--;
                }
                dir_x*= -1;
            }
            else { //go horizontal
                if(dir_y > 0) { //go bottom - works
                    System.out.println("go bottom");
                    while(y < bpointer) {
                        int item = matrix[x][y];
                        System.out.println("item " + item);
                        row.add(item);
                        y++;
                    }
                //    tpointer++;
                    rpointer--;
                }
                else {
                    System.out.println("go top");
                    while(y > tpointer) { //go top
                        int item = matrix[x][y];
                        System.out.println("item " + item);
                        row.add(item);
                        y--;
                    }
                //    bpointer--;
                    lpointer++;
                }
                dir_y*= -1;
            }
            side++;
        }

        return row;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();

        int X = matrix.length;
        int Y = matrix[0].length;
        if (X == 0) return ans;
        boolean[][] visited = new boolean[X][Y];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int dir = 0;

        for (int i = 0; i < X * Y; i++) {
            ans.add(matrix[x][y]);
            visited[x][y] = true;
            int next_x = x + dx[dir];
            int next_y = y + dy[dir];

            if(next_x >= 0 && next_y >= 0 && next_x < X && next_y < Y && !visited[next_x][next_y]) {
                x = next_x;
                y = next_y;
            } else {
                dir = (dir + 1) % 4;
                x+= dx[dir];
                y+= dy[dir];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3},
                                      {4,5,6},
                                      {7,8,9}};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
        piralMatrix s = new piralMatrix();
        List<Integer> row = s.spiralOrder(matrix);
        System.out.println(row.toString());
    }
}

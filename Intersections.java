package com.company;

import java.util.ArrayList;
import java.util.List;

public class Intersections {

    public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
    }

    public static Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A.length == 0 || B.length == 0) return new Interval[0];

        Interval[] result= new Interval[(A.length > B.length ? A.length  : B.length ) + 2];
        int i = 0;

        Interval ia = A[0];
        Interval ib = B[0];
        int a = 1;
        int b = 1;
        List<Interval> list = new ArrayList<>();
        while( a < A.length || b < B.length) {
            if (ia.start > ib.end) {
                if (b >= B.length) break;
                ib = B[b++];
            }
            else if (ia.end < ib.start) {
                if (a >= A.length) break;
                ia =  A[a++];
            }
            else {
                int start = ia.start <= ib.start ? ib.start : ia.start;
                int end = ia.end < ib.end ? ia.end : ib.end;
                list.add(new Interval(start, end));

//                if (b >= B.length) break;
                if (ia.end < ib.end) {
                    if (a >= A.length) break;
                    ia =  A[a++];
                }
                else if (ia.end > ib.end) {
                    if (b >= B.length) break;
                    ib = B[b++];
                }
                else {
                    if (b >= B.length && a >= A.length) break;
                    ia = a < A.length ? A[a++]: ia;
                    ib = b < B.length ? B[b++]: ib;
                }
            }
        }

        int start = ia.start <= ib.start ? ib.start : ia.start;
        int end = ia.end < ib.end ? ia.end : ib.end;
        if (start <= end)
            if (i > 0 && list.get(i - 1).start != start )
                list.add(new Interval(start, end));


        return list.toArray(new Interval[list.size()]);
    }

    public static void main(String[] args) {
//        Interval[] A = new Interval[] {new Interval(2,5), new Interval(7,8),new Interval(11,13), new Interval(18,20)};
//[[0,12]]//4, 11)};//{new Interval(0,2),new Interval(5,10),new Interval(13,23),new Interval(24,25)};
//        Interval[] B = new Interval[] {new Interval(0, 12)};//1,2), new Interval(8,11), new Interval(12,13), new Interval(14,15), new Interval(17,19)};//{new Interval(1,5),new Interval(8,12), new Interval(15,24), new Interval(25,26)};
        Interval[] A = new Interval[] {new Interval(0,2),new Interval(5,10),new Interval(13,23),new Interval(24,25)};
        Interval[] B = new Interval[] {new Interval(1,5),new Interval(8,12), new Interval(15,24), new Interval(25,26)};

//        Interval[] A = new Interval[] {new Interval(4, 7), new Interval(8, 14   )};//{new Interval(0,2),new Interval(5,10),new Interval(13,23),new Interval(24,25)};
//        Interval[] B = new Interval[] {new Interval(3, 4)};

        Interval[] res = intervalIntersection(A, B);

        for (int i = 0; i < res.length; i++) {
//            System.out.println("[" + res[i].start + ", " + res[i].end + "]");
        }
    }
}

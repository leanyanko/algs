package c_successor;

/*
*Question 3.
* Successor with delete. Given a set of N integers S and a sequence of requests of the following form:
* Remove x from S
* Find the successor of x: the smallest y in S such that y>=x .
* design a data type so that all operations (except construction) should take logarithmic time or better.
*/

import java.util.Arrays;


public class Successor {

    int [] S;
    int max[];
    int size;

    public Successor(int [] input) {
        size = input.length;
        S = new int[size];
        max = new int[size];

    }

    private void add(int x) {

    }

    public int delete (int x) {
        int y = 0;


        return y;
    }
}

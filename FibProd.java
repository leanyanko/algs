package com.company;

public class FibProd {
    public static long[] productFib(long prod) {
        long fiba = 0;
        long fibb = 1;

        while (fiba * fibb < prod) {
            long fibnext = fiba + fibb;
            fiba = fibb;
            fibb = fibnext;
            if (fiba * fibb == prod) return new long[] {fiba, fibb, 1};
        }
        return new long[] {fiba, fibb, 0};
    }
}

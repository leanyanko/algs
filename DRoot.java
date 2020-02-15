package com.company;

public class DRoot {
    public static int digital_root(int n) {
        float test = (float)n/10;
        System.out.println("test " + test);
        if (test < 1.0) return n;

        int sum = 0;
        while(n >= 1){
       //     if (n == 10) sum += 1;
       //     else
                sum += n % 10;
            System.out.println("sum " + sum);
            n = n / 10;
        }
        return digital_root(sum);
    }

    public static void main(String[] args) {
        System.out.println("ans " + digital_root(16));
        System.out.println();
        System.out.println("ans " + digital_root(456));
        System.out.println();
        System.out.println("ans " + digital_root(456));
    }
}

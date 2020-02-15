package com.company;

public class Partition {
    public static boolean canThreePartsEqualSum(int[] A) {
        if (A.length < 3) return false;
        int sum = 0;
        for (int i = 0; i < A.length; i++)
            sum+=A[i];

        if (sum % 3 != 0) return false;
        int target = sum / 3;

        System.out.println("target " + target);
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count += A[i];
            if (count == target) {
                count = 0;
            }
//            else if (count > target) {
//                System.out.println(count);
//                return false;
//            }
        }
        if (count != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(canThreePartsEqualSum(A));
        int[] B = new int[]{0,2,1,-6,6,7,9,-1,2,0,1};
        System.out.println(canThreePartsEqualSum(B));
        int[] C = new int[]{3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(canThreePartsEqualSum(C));
    }
}

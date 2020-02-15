package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Pivot {
//    public static int pivotIndex(int[] nums) {
//
//        int size = nums.length;
//        if (size == 0) return -1;
//        int left = 0;
//        int right = size - 1;
//        int l = nums[0];
//        int r = nums[size - 1];
//        System.out.println(" left " + left +", right " + right + ", l " + l + ", r " + r);
//        while (left < right) {
//            if (l == r && left == right - 2) return ++left;
//          //  System.out.println(left +"=" + right + " && " + l + "=" + r);
//            if (l < r && l >= 0 || l > r && r <= 0) {
//                l+= nums[++left];
//            }
//            else {
//                r+= nums[--right];
//            }
//            if (l == r && left == right) return left;
//            System.out.println(" left " + left +", right " + right + ", l " + l + ", r " + r);
//        }
//        return -1;
//    }
public static int pivotIndex(int[] nums) {
    int len = nums.length;
    if (len == 0) return -1;
    if (len == 1) return 0;

    int largest = 0;
    int second = 1;

    for (int i = 0; i < len; i++) {
        int current = nums[i];
        if(current > nums[largest]) {
            second = largest;
            largest = i;
        }
        else if (current != nums[largest] && current > nums[second]) {
            second = i;
        }
    }
    return (nums[second]*2 <= nums[largest]) ? largest : -1;
}

    public static int dominantIndex(int[] nums) {
    LinkedList<Integer> l = new LinkedList<>();
    int len = nums.length;
        if(len == 0) return -1;
        if(len == 1) return 0;
        int largest = 0;
        int second = 1;

        for(int i = 0; i < len; i++) {
            int current = nums[i];
            if(current > nums[largest]) {
                second = largest;
                largest = i;
            }
            else if(current != nums[largest] && current > nums[second]){
                second = i;
            }
        }
        return nums[second] * 2 <= nums[largest] ? largest : -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,-1,-1,0}; //2
//        int[] nums = {-1,-1,-1,-1,-1,-1}; //-1
//        int[] nums = {1, 7, 3, 6, 5, 6}; //3
//        int[] nums = {-1,-1,-1,0,1,1}; //0
//        int[] nums = {-1,-1,-1,1,1,1};
//        int[] nums = {-1,-1,0,1,0,-1};
//        int[] nums = {1, 0}; //0
        System.out.println(dominantIndex(nums));
    }
}

package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return nums[len - 1];
        System.out.println(Arrays.toString(nums));
    //    System.out.println(nums.length);
        int pointer = len - 1;
        int counter = 0;

        Map<Integer, Integer>  map = new HashMap<>();
        while(pointer >= 0) {
            int num = nums[pointer];
            if(!map.containsKey(num)) {
                map.put(num, num);
                counter++;
            }
            if (counter == 3) return num;
            pointer--;
        }
        return nums[len - 1];
    }

    public static void main(String[] args) {
        //int[] nums = {1,2,2,5,3,5};
        //int[] nums = {2,2,2,1};
        //int[] nums = {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
        //int[] nums = {3,2,1};
        int[] nums = {2,2,3,1};
        ThirdMax thir = new ThirdMax();
        int ans = thir.thirdMax(nums);
        System.out.println("--------");
        System.out.println(ans);
    }
}

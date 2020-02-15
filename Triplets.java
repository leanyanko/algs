package com.company;

import java.util.*;

public class Triplets {
    Map<Integer, Map<Integer, Integer>> nonrepeats = new HashMap<>();

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> options = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;

            if (nums[i] <= 0 && (i == 0 || i > 0 && nums[i] != nums[i - 1])) {
                int target = nums[i] * -1;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == target) {// &&
                        ArrayList<Integer> option = new ArrayList<Integer>();
                        option.add(nums[i]);
                        option.add(nums[lo]);
                        option.add(nums[hi]);
                        options.add(option);
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if(nums[lo] + nums[hi] > target) hi--;
                    else lo++;
                }
            }
        }

        return options;
    }


    public static void main(String[] args) {
        Triplets tr = new Triplets();
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> tripples = tr.threeSum(nums);
        System.out.println("-----");
        for (int i = 0; i < tripples.size(); i ++) {
            System.out.println(tripples.get(i).toString());
        }
    }
}

package com.company;

import java.util.*;

public class ArraysIntersections {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int p1 = 0;
        int p2 = 0;
        if (len1 == 0 || len2 == 0 || nums1[len1 - 1] < nums2[p2] || nums1[p1] > nums2[len2 - 1]) return new int[] {};

        Stack<Integer> ans = new Stack<>();

        while (p1 < len1 && p2 < len2) {
            int tar = nums1[p1];
            int tar2 = nums2[p2];
            if (tar == tar2) {
                ans.push(tar);
                p1++;
                p2++;
            }
            else if(tar > tar2) p2++;
            else p1++;
        }

        int [] a = new int[ans.size()];

        int i = 0;
        while(!ans.empty()) {
            a[i++] = ans.pop();
        }

        return a;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int p1 = 0;
        int p2 = 0;
        if (len1 == 0 || len2 == 0 || nums1[len1 - 1] < nums2[p2] || nums1[p1] > nums2[len2 - 1]) return new int[] {};

        Map<Integer, Integer> ans = new HashMap<>();

        while (p1 < len1 && p2 < len2) {
            int tar = nums1[p1];
            int tar2 = nums2[p2];
            if (tar == tar2) {
                if(!ans.containsKey(tar)) {
                    ans.put(tar, tar);
                }
                p1++;
                p2++;
            }
            else if(tar > tar2) p2++;
            else p1++;
        }

        int [] a = new int[ans.size()];

        int i = 0;
        for (Integer item: ans.keySet()) {
            a[i++] = item.intValue();
        }
        return a;
    }

    public Integer[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int p1 = 0;
        int p2 = 0;
        if (nums1[len1 - 1] < nums2[p2] || nums1[p1] > nums2[len2 - 1]) return new Integer[] {};

        // int[] ans = new int [len1 > len2 ? len1 : len2];
        // int pointer = 0;
        Map<Integer, Integer> ans = new HashMap<>();

        while (p1 < len1 - 1 && p2 < len2) {
            int tar = nums1[p1];
            int tar2 = nums2[p2];
            if (tar == tar2) {
                if(!ans.containsKey(tar)) {
                    ans.put(tar, tar);
                }
                p1++;
                p2++;
            }
            else if(tar > tar2) p2++;
            else p1++;
        }

        Integer[] a = ans.keySet().toArray(new Integer[ans.size()]);

        return a;
    }

    public static void main(String[] args) {
//        int[] nums1 = {9,4,9,8,4};
//        int[] nums2 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] nums1 = {4,9,5};
        ArraysIntersections ar = new ArraysIntersections();
        int[] ans = ar.intersection(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }
}

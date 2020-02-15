package com.company;

public class ArrToTree {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

//    public TreeNode sortedArrayToBST(int[] nums) {
//        int len = nums.length;
//        TreeNode root = new TreeNode(nums[len/2]);
//        int le = len/2 - 1;
//        int ri = len - 1;
//
//        for (int i = 0; i < nums.length; i++) {
//            TreeNode pointer = root;
//            int val = nums[i];
//            System.out.println("val " + val);
//            if(val != root.val)
//            while(pointer != null) {
//                System.out.println(pointer.val > val);
//                if (pointer.val > val) {
//                    if (pointer.left == null) pointer.left = new TreeNode(val);
//                    pointer = pointer.left;
//                }
//                else if (pointer.val < val) {
//                    if (pointer.right == null) pointer.right = new TreeNode(val);
//                    pointer = pointer.right;
//                }
//                else pointer = null;
//            }
//        //    pointer = new TreeNode(val);
//            System.out.println("right " + root.right.val);
//            System.out.println("left " + root.left.val);
//        }
//        return root;
//    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        TreeNode root = sink(nums, 0, nums.length - 1);

        return root;
    }
    private TreeNode sink (int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int middle = (hi + lo) / 2;
        TreeNode next = new TreeNode(nums[middle]);

        next.left = sink(nums, lo, middle - 1);
        next.right = sink(nums, middle + 1, hi);

        return next;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-10,-3,0,5,9};
        ArrToTree ar = new ArrToTree();
        TreeNode tree = ar.sortedArrayToBST(nums);

    }
}

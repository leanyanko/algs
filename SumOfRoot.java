package com.company;

import com.company.trees.MinimalTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumOfRoot {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumRootToLeaf(TreeNode root) {
        int ans = 0;
        List<Integer> list = inorderTraversal(root);
        int[] arr = new int[list.size()];
        int i =0;
        for (int j : list) arr[i++] = j;

        return ans;
    }

    private List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> output = new ArrayList<>();
         preorder(output, root);
         return output;
    }

    private void preorder(List<Integer> output, TreeNode node) {
         if (node != null) {
             preorder(output, node.left);
             output.add(node.val);
             preorder(output, node.right);
         }
    }

    public static TreeNode root;

    public void MinimalTree(int[] input) {

        int len = input.length;
        int init = len/2;
        insert(init);
        int i = 0;
        while (i <= init) {
            int l = init - i;
            int r = init + i;

            if (l >= 0) insert(input[l]);
            if (r < len) insert(input[r]);
            i++;
        }
    }

    private void insert (int val) {
        root = insert(root, val);
    }

    private TreeNode insert (TreeNode x, int val) {
        if (x == null)return new TreeNode(val);
        if (x.val > val) x.left = insert(x.left, val);
        else if (x.val < val) x.right = insert(x.right, val);
        return x;
    }

    public void print(TreeNode node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.val);
            print(node.right);
        }
    }

    public static void main(String[] args) {
//        int[] input = new int[]{15,13,12,11,9,5,4,3,1,0};
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        SumOfRoot s = new SumOfRoot();
        s.MinimalTree(input);

        System.out.println(s.sumRootToLeaf(root));
//        s.print(root);
//        System.out.println(s.inorderTraversal(root).toString());
    }
}

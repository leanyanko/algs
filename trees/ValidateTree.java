package com.company.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidateTree {
    public static boolean validateTree(MinimalTree.TreeNode root) {
        if (root != null) {
            if (root.right != null && root.val >= root.right.val || root.left != null && root.val <= root.left.val) return false;
            validateTree(root.left);
            validateTree(root.right);
        }
        return true;
    }

    public List<List<Integer>> levelOrder(MinimalTree.TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);

        return res;
    }

    public void helper (List<List<Integer>> res, MinimalTree.TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) res.add(new ArrayList<>());
        res.get(height).add(root.val);
        helper(res,root.left, height + 1);
        helper(res,root.right, height + 1);
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        MinimalTree tree = new MinimalTree(input);
        MinimalTree.TreeNode bst = tree.root;
        MinimalTree.TreeNode not_bst = tree.createNotBST(input);
        System.out.println(validateTree(bst));
        System.out.println(validateTree(not_bst));
    }
}

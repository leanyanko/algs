package com.company;

import java.util.ArrayList;
import java.util.List;

public class TreeToArr {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);

        return res;
    }

    public void helper (List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height > res.size()) res.add(new ArrayList<>());
        res.get(height).add(root.val);
        helper(res,root.left, height + 1);
        helper(res,root.right, height + 1);
    }
}

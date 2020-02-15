package com.company.trees;

public class MaxDif {
    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    //    public int maxAncestorDiff(TreeNode root) {
    //        return Math.max(maxAncestorDiff(root.left, Integer.MIN_VALUE, root.val, 0),maxAncestorDiff(root.right, Integer.MIN_VALUE, root.val, 0));
    //    }
    //    public int maxAncestorDiff(TreeNode root, int max, int rootval, int prevdif) {
    //        if (root == null) return max;
    //        int dif = rootval - root.val;
    //        int preroot =
    //        max = tmp > max ? tmp : max;
    //        int max_left = maxAncestorDiff(root.left, max, root.val);
    //        int max_righ = maxAncestorDiff(root.right, max, root.val);
    //        max = Math.max(max_left, max);
    //        return Math.max(max, max_righ);
    //    }

    public static int result;
    public int MaxAncestorDiff(TreeNode root) {
        int result = 0;
        MaxAncestorDiffRec(root, root.val, root.val);
        return result;
    }

    public void MaxAncestorDiffRec(TreeNode root, int max, int min) {
        if (root == null) return;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        result = Math.max(result, Math.abs(root.val - min));
        result = Math.max(result, Math.abs(max - root.val));

        MaxAncestorDiffRec(root.left, max, min);
        MaxAncestorDiffRec(root.right, max, min);
    }

    public static void main(String[] args) {

    }
}

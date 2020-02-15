package com.company;

public class Neighbors {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        int d_x = depth(root, x, 0);
        int d_y = depth(root, y, 0);
        System.out.println(d_x);
        System.out.println(d_y);
        return d_x == d_y && parent(root, x) != parent(root, y);
    }

    private static int depth(TreeNode root, int x, int depth) {
        if (root == null) return 0;
        if (root.val == x) return depth;

        int left = depth(root.left, x, depth + 1);
        int right = depth(root.right, x, depth + 1);
//        System.out.println(x + ": left: " + left + ", right: " + right);
        return left + right;
    }

    private static TreeNode parent (TreeNode root, int x) {
        if (root == null) return null;
        if (root. left != null && root.left.val == x || root.right != null && root.right.val == x) {
//            System.out.println("parents of " + x + ", returning " + root.val);
            return root;
        }

        TreeNode left = parent(root.left, x);
        TreeNode right = parent(root.right, x);
//        System.out.println("parents of " + x + ", left: " + left + ", right " + right);
        return  left == null ? right : left;
    }

    private static boolean sameRoot(TreeNode root, int x, int y) {
//        if (root.left != null && root.left.val == x && root.right != null && root.right.val != y
//                || root.left != null && root.left.val != x && root.right != null && root.right.val == y) return false;
//
//        if (root.left != null && root.left.val == x && root.right == null || root.right != null && root.right.val == y && root.left == null) return false;

        if (root.left != null) {

        }

        if (root.right != null) {

        }

        return true;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
//        System.out.println(isCousins(root, 2, 3));
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5)));
        System.out.println(isCousins(root, 4, 5 ));
    }
}

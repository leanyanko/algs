package com.company;

public class Nodes {
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }

          TreeNode(int x, TreeNode left, TreeNode right) {
              val = x;
              this.left = left;
              this.right = right;
          }
     }

    public static TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;
        if (root.val == val) return root;

        if (root.val > val) return searchBST(root.left, val);

        if (root.val < val) return searchBST(root.right, val);

        return null;
    }

    public static void main(String[] args) {
         //[4,2,7,1,3]
         //5
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        System.out.println(searchBST(root, 5));
    }
}

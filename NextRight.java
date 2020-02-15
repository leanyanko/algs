package com.company;


import java.util.regex.*;

public class NextRight {
    public static  class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
        TreeLinkNode(int x, TreeLinkNode right) { val = x; this.right = right;}
    }

    public static void connect2(TreeLinkNode root) {
        if(root.right != null) {
            root.next = root.right;
            connect(root.right);
            connect(root.left);
        }
    }

    public static void connect(TreeLinkNode root) {
        while(root.left != null) {
            root.left.next = root.right;
            root = root.left;
        }
    }


    public static void helper(TreeLinkNode root) {}

    public static void main(String[] args) {
//        TreeLinkNode tree = new TreeLinkNode(1, new TreeLinkNode(2, new TreeLinkNode(3, new TreeLinkNode(4))));
//        connect(tree);
//        while (tree != null) {
//            System.out.println(tree.val);
//            tree = tree.next;
//        }

            /* Enter your code here. Read input from STDIN. Print output to STDOUT */
            String s = "7";
            String pattern = "[a-d1-7]";
            System.out.println(s.matches(pattern));

    }
}

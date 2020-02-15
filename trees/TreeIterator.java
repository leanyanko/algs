package com.company.trees;

public class TreeIterator {
    public static TreeNode root;

    public TreeIterator(){}

    public TreeIterator(TreeNode root) {
        this.root = root;

        TreeNode[] nodes = new TreeNode[count(root)];
    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.right) + count(root.left);
    }



    public int next() {
        return 0;
    }

    public boolean hasNext() {
        return true;
    }





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


    public TreeNode createNotBST(int[] input) {
        TreeNode nbst = new TreeNode(3, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        return nbst;
    }

    public TreeNode createTree(int[] input) {
        int len = input.length;
        put(input, 0, len - 1);
        return root;
    }

    private void put (int[] input, int start, int end) {
        if (end < start) return;
        int mid = (start + end) / 2;
        insert(input[mid]);
        put(input, start, mid - 1);
        put(input, mid + 1, end);
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

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        MinimalTree tree = new MinimalTree(input);
//        MinimalTree.TreeNode bst = tree.root;

        TreeIterator iterator = new TreeIterator();
        TreeNode bst = iterator.createTree(input);
        System.out.println(iterator.count(bst));
    }

}

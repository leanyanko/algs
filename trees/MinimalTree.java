package com.company.trees;

/*
Given a sorted array (increasing order) with the unique integer elements. Write an algorithm to create a binary search tree out of it.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MinimalTree {
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

    public static TreeNode root;

    public TreeNode createNotBST(int[] input) {
        TreeNode nbst = new TreeNode(3, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        return nbst;
    }

    public MinimalTree(int[] input) {
        int len = input.length;
        put(input, 0, len - 1);
    }

    private void put (int[] input, int start, int end) {
        if (end < start) return;
        int mid = (start + end) / 2;
        insert(input[mid]);
        put(input, start, mid - 1);
        put(input, mid + 1, end);
    }

    private void insert (int val) {
        root = insert2(root, val);
    }

    private TreeNode insert (TreeNode x, int val) {
        if (x == null)return new TreeNode(val);
        if (x.val > val) x.left = insert(x.left, val);
        else if (x.val < val) x.right = insert(x.right, val);
        return x;
    }

    public TreeNode search (int val) {
        TreeNode x = root;
        while(x != null) {
            if (val == x.val) return x;
            x = val > x.val ? x.right : x.left;
        }

        return null;
    }

    public boolean iterativeSearch (int val) {
        TreeNode x = root;
        while(x != null) {
            if (val == x.val) return true;
            x = val > x.val ? x.right : x.left;
        }
        return false;
    }

    public void delete (int val) {
        root = delete(root, val);
    }

    private TreeNode delete (TreeNode x, int val) {
        if (x == null) return null;
        if (val < x.val) x.left = delete(x.left, val);
        else if (val > x.val) x.right = delete(x.right, val);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;

            TreeNode t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }


    private TreeNode min (TreeNode t) {
        if (t.left == null) return t;
        return t.left;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private TreeNode deleteMin (TreeNode x) {
        if (x.left == null) return x.right; //ignoring x itself!
        x.left = deleteMin(x.left);
        return x;
    }

    public void print(TreeNode node) {
        if (node != null) {
            print(node.left);
            print(node.right);
            System.out.println(node.val);
        }
    }

    public void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.left);
            visit(node.val);
            traverse(node.right);
        }
    }

    private void visit(int val) {
        System.out.println(val);
    }

/*
1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
*/
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();

        TreeNode current = root;

        while (current != null || !nodes.empty()) {
            while (current != null) {
                nodes.push(current);
                current = current.left;
            }

            current = nodes.pop();
            output.add(current.val);
            current = current.right;
        }
        return output;
    }

    /*
  1)  Create an empty stack nodeStack and push root node to stack.
  2) Do following while nodeStack is not empty.
    a) Pop an item from stack and print it.
    b) Push right child of popped item to stack
    c) Push left child of popped item to stack
     */
    public List<Integer> preorderTraversalIterative(TreeNode node) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();

        TreeNode current = root;

        nodes.push(current);
        while (!nodes.empty()) {
            current = nodes.pop();
            output.add(current.val);

            if(current.right != null) nodes.push(current.right);
            if(current.left != null) nodes.push(current.left);
        }
        return output;
    }


    /*
1.1 Create an empty stack
2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
    */

    List<Integer> postOrderIterative(TreeNode node) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(node);
        TreeNode prev = null;
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.peek();
            if (prev == null || prev.left == current ||
                    prev.right == current) {
                if (current.left != null)
                    nodes.push(current.left);
                else if (current.right != null)
                    nodes.push(current.right);
                else {
                    nodes.pop();
                    output.add(current.val);
                }
            }
            else if (current.left == prev) {
                if (current.right != null)
                    nodes.push(current.right);
                else {
                    nodes.pop();
                    output.add(current.val);
                }
            }
            else if (current.right == prev) {
                nodes.pop();
                output.add(current.val);
            }
            prev = current;
        }

        return output;
    }

    public TreeNode search2 (int val, TreeNode x) {
        if (x == null) return null;
            if (val == x.val) return x;
            if (val > x.val) return search2(val, x.right);
            return search2(val, x.left);
    }


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    private TreeNode delete2 (TreeNode x, int val) {
//        while(x != null && x.val != val)
//        x = search(val);
        if (x == null) return null;
        if (x.val != val) return delete(search2(val, x), val );
//        if (val < x.val) x.left = delete(x.left, val);
//        else if (val > x.val) x.right = delete(x.right, val);
//        else {
        if (x.right == null) return x.left;
        if (x.left == null) return x.right;

        TreeNode t = x;
        x = min(t.right);
        x.right = deleteMin(t.right);
        x.left = t.left;
//        }
        return x;
    }

    public void delete2 (int val) {
        root = delete2(root, val);
    }


    public TreeNode insert2 (TreeNode x, int val) {
        if (x == null) return new TreeNode(val);
//        if (val == x.val) return x;
        if (val > x.val) return insert2(x.right, val);
        return insert2(x.left, val);
    }


    public static void main(String[] args) {
//        int[] input = new int[]{15,13,12,11,9,5,4,3,1,0};
//        Stack<> stack = new Stack<>();
//        stack.push(1);
//        stack.push(1);
//        stack.push(1);
//        stack.pop();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        MinimalTree bst = new MinimalTree(input);
//        System.out.println(bst.search2(2, bst.root).val);
//        bst.insert(10);
//        bst.delete2(7);
//        bst.print(bst.deleteMin(bst.search(7).right));
        System.out.println();
        bst.traverse(bst.root);


//        System.out.println(bst.inorderTraversal(bst.root).toString());
//        System.out.println(bst.preorderTraversalSemirecursive(bst.root).toString());
//        System.out.println(bst.postOrderIterative(bst.root).toString());
    }
}







//    List<Integer> postOrderIterative(TreeNode node)
//    {
//        List<Integer> output = new ArrayList<>();
//        Stack<TreeNode> nodes = new Stack<>();
//        nodes.push(node);
//        TreeNode prev = null;
//        while (!nodes.isEmpty())
//        {
//            TreeNode current = nodes.peek();
//
//            /* go down the tree in search of a leaf an if so process it
//            and pop stack otherwise move down */
//            if (prev == null || prev.left == current ||
//                    prev.right == current)
//            {
//                if (current.left != null)
//                    nodes.push(current.left);
//                else if (current.right != null)
//                    nodes.push(current.right);
//                else
//                {
//                    nodes.pop();
//                    output.add(current.val);
//                }
//
//                /* go up the tree from left node, if the child is right
//                   push it onto stack otherwise process parent and pop
//                   stack */
//            }
//            else if (current.left == prev)
//            {
//                if (current.right != null)
//                    nodes.push(current.right);
//                else
//                {
//                    nodes.pop();
//                    output.add(current.val);
//                }
//
//                /* go up the tree from right node and after coming back
//                 from right node process parent and pop stack */
//            }
//            else if (current.right == prev)
//            {
//                nodes.pop();
//                output.add(current.val);
//            }
//
//            prev = current;
//        }
//
//        return output;
//    }




//        int init = len/2 + 1;
//        insert(init);
//        int i = 0;
//        while (i <= init) {
//            int l = init - i;
//            int r = init + i;
//
//            if (l >= 0) insert(input[l]);
//            if (r < len) insert(input[r]);
//            i++;
//        }




//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> output = new ArrayList<>();
//        Stack<TreeNode> nodes = new Stack<>();
//
//        TreeNode current = root;
//        nodes.push(current);
//        while (current != null || !nodes.empty()) {
//            current = nodes.pop();
//            current = current.right;
//            output.add(current.val);
//
//            while (current != null) {
//                nodes.push(current);
//                current = current.left;
//            }
//        }
//        return output;
//    }

//
//    public List<Integer> preorderTraversalSemirecursive(TreeNode root) {
//        List<Integer> output = new ArrayList<>();
//        preorderTraversal(output, root);
//        return output;
//    }
//
//    private void preorderTraversal(List<Integer> output, TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        Stack<TreeNode> nodes = new Stack<>();
//        TreeNode current = root;
//        nodes.push(current);
//        while (!nodes.empty()) {
//            current = nodes.pop();
//            output.add(current.val);
//
//            if(current.right != null) nodes.push(current.right);
//            if(current.left != null) nodes.push(current.left);
//        }
//    }
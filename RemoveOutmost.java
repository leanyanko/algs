package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveOutmost {
    public static String removeOuterParentheses(String S) {
        Stack<Integer> indexes = new Stack<>();
        StringBuilder output = new StringBuilder(S);
        List<Integer> ind = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') indexes.push(i);

            if (S.charAt(i) == ')') {
                int tmp = indexes.pop();
//                System.out.println("pop");
                if (indexes.empty()) {
                    ind.add(tmp);
                    ind.add(i);
                }
            }
        }

        int[] arr = new int[ind.size()];
        int i = 0;
        for (int j: ind) arr[i++] = j;

        for (i = arr.length - 1; i >= 0; i--) {
            output.deleteCharAt(arr[i]);
        }

        return output.toString();
//        return ind.toString();
//        return indexes.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }
}

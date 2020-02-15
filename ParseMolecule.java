package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class ParseMolecule {

    private static class Pointer {
        int val;
        public Pointer() {
            this.val = 0;
        }
    }

    public static Map<String,Integer> getAtoms(String formula) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        Pointer pointer = new Pointer();
        pointer.val = 0;
        map = insideBracets(formula, pointer);

        return map;
    }

    public static Map<String, Integer> insideBracets (String formula, Pointer pointer) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        while (pointer.val < formula.length()) {
            int i = pointer.val;
            String s = getOneElement(formula, pointer, map);
            pointer.val++;
         //   String m = getOneElement(formula, pointer);

            System.out.println();
        }
        return map;
    }

    private static void multiplyBy (Map<String, Integer> map, int by, String element) {
            if (map.containsKey(element)) map.put(element, map.get(element) * by);
            else map.put(element, by);
    }

    private static void inBrackets(String formula, Pointer pointer, char bracket, Map<String, Integer> map) {
        if (formula.charAt(pointer.val) == bracket) {
            int i = pointer.val++;
            char closed = bracket == '(' ? ')' : ']';
            while(formula.charAt(i) != closed){
                i++;
            }
            String sub = formula.substring(pointer.val, i);
            System.out.println("in br " + sub);
        //    String a = getOneElement(sub,pointer, map);
            if (formula.charAt(i + 1) > '0' && formula.charAt(i + 1) < '9') System.out.println("number is: " + formula.charAt(i+1));
            pointer.val = i++;
        }
    }

    private static String getOneElement(String formula, Pointer pointer, Map<String, Integer> map) {

        if (pointer.val == formula.length() - 1) return "";
        if (formula.charAt(pointer.val) == '(' ||  (formula.charAt(pointer.val) == '[')) {
            char bracket = formula.charAt(pointer.val);
            inBrackets(formula, pointer, bracket, map);
        }


        int start = pointer.val;
        System.out.println("pointer: " + pointer.val);

        char low = formula.charAt(pointer.val + 1);
        System.out.println("char: " + low);

        if (low > 'a' && low < 'z') pointer.val++;

        System.out.println("pointer: " + pointer.val);
        String element = formula.substring(start, pointer.val + 1);

        System.out.println("element: " + element);

//        pointer.val++;
        return element;
    }
    static void plusMinus(int[] arr) {
        int negatives = 0;
        int positives = 0;
        int zeros = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) positives ++;
            else if (arr[i] < 0) negatives++;
            else zeros++;

        }

        double[] ans = new double[] {(double)positives/arr.length, (double)negatives/arr.length, (double)zeros/arr.length};
        for (int i = 0; i < 3; i++) {
            System.out.printf("%.6f\n",ans[i]);
            //     System.out.printf("%.6f\n",(double)positives/arr.length);
            // System.out.printf("%.6f\n", (double)negatives/arr.length);
            // System.out.printf("%.6f", (double)zeros/arr.length);
        }
    }

    static void plusMinus1(int[] arr) {
        int negatives = 0;
        int positives = 0;
        int zeros = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) positives ++;
            else if (arr[i] < 0) negatives++;
            else zeros++;

        }

     //   return new double[] {positives/arr.length, negatives/arr.length, zeros/arr.length};

    }

    public static void main(String[] args) {
        System.out.println(getAtoms("Mg(OH)2"));
        System.out.println(getAtoms("K4[ON(SO3)2]2"));

    }
}

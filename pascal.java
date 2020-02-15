package com.company;

import java.util.Arrays;
import java.util.List;

public class pascal {
    public List<Integer> getRow(int rowIndex) {
        Integer[] list = new Integer[]{1};
        while (rowIndex > 0) {
            list = getLevel(list);
            rowIndex--;
        }
//        List<Integer> test = Arrays.asList(list);
        return Arrays.asList(list);
    }

    private Integer[] getLevel (Integer[] list) {
        Integer[] level = new Integer[list.length + 1];
        level[0] = 1;
        for (int i = 0; i < list.length - 1; i++) {
            level[i] = list[i] + list[i + 1];
        }
        level[level.length - 1] = 1;
        return level;
    }
    public static String reverseWords(String s) {
//        s = s.replaceAll("\\s+", ".");
//        System.out.println(s);
        String[] arr = s.split(" ");
        StringBuilder b = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--){
            StringBuilder st = new StringBuilder();
            for (int j = 0; j < arr[i].length(); j++) {
                char ch = arr[i].charAt(j);
                if (ch != ' ') {
                    System.out.println("--" + ch);
                    st.append(ch);
                }
            }

            System.out.println(st.toString());
            b.append(st.toString() + " ");
        }
//        if (b.charAt(b.length() - 1) == ' ') b.delete()
        return b.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("srg   set      gst"));
    }
}

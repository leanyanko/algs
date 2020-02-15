package com.company;

import java.util.ArrayList;
import java.util.List;

public class CamelMatch {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> output = new ArrayList<>();
        List<String> parts = detach(pattern);
        System.out.println(parts.toString());

        for (int i = 0; i < queries.length; i++) {
//            StringBuilder s = new StringBuilder(queries[i]);
            String query = queries[i];

            boolean o = true;
            for (String part: parts) {
                if (query.indexOf(part) < 0) o = false;
                else {
                    query.replaceFirst(part, "");
                }
            }
            for (int j = 0; j < query.length(); j++) {
                char ch = query.charAt(j);
                if (ch >= 'A' && ch <= 'Z') {
                    o = false;
                    break;
                }
            }
            output.add(o);

        }
        return output;
    }

    private static List<String> detach (String pattern) {
        List<String> list = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (ch >= 'A' && ch <= 'Z') indexes.add(i);
        }

        System.out.println(indexes.toString());
        int[] arr = new int[indexes.size()];
        int i = 0; for (int a: indexes) arr[i++] = a;
        int start = arr[0];

        i = 0;

        while (i < arr.length - 1) {
            System.out.println(i);
            String s = pattern.substring(start, arr[i + 1] - 1);
            System.out.println(s);
            list.add(s);
            start = arr[i + 1];
            i ++;
        }
        return list;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        System.out.println(camelMatch(s, "FB"));
        String[] su = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        System.out.println(camelMatch(su, "FoBa"));
    }
}

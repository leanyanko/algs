package com.company;

public class Build {
    public static String toLowerCase(String str) {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            build.append(Character.toLowerCase(str.charAt(i)));
        }

        return build.toString();
    }


    public static void main(String[] args) {
        System.out.println(toLowerCase("JLJLnljnlLJ"));
    }
}

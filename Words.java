package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Words {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        for (String word: wordDict) {
//            if(s.indexOf(word) >= 0) s = s.replace(word, "");
//            else return false;
//            System.out.println(s);
//        }
//        return true;
//    }
//public boolean wordBreak(String s, List<String> wordDict) {
//    if (wordDict.size() == 0) return false;
//
//    String[] dict = new String[wordDict.size()];
//    int i = 0;
//    for (String word: wordDict) {
//        dict[i++] = word;
//    }
//
//    while(wordDict.size() > 0 && s.length() > 0) {
//        for (i = 0; i < dict.length; i++) {
//            String word = dict[i];
//            if(s.indexOf(word) >= 0) {
//                s = s.replace(word, "");
//                System.out.println(s);
//            }
//            else {
//                wordDict.remove(word);
//            }
//        }
//
//    }
//    if (s.length() > 0) return false;
//    return true;
//}

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0) return false;

        int size = s.length();
        boolean[] f = new boolean[size + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(i + ", " + s.substring(j, i));
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[size];
    }

    public static void main(String[] args) {
        Words words = new Words();
        ArrayList<String> dict = new ArrayList<>();
//        dict.add("cats");
//        dict.add("dog");
//        dict.add("sand");
//        dict.add("and");
//        dict.add("cat");
        String word = "cars";
        dict.add("car");
        dict.add("ca");
        dict.add("rs");
        System.out.println(words.wordBreak(word,dict));
        word = "catsandog";
       // System.out.println(words.wordBreak("catsandog",dict));
    }
}

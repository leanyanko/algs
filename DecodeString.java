package com.company;

public class DecodeString {
    private static class Pointer {
        int val;
        Pointer() {
            val = 0;
        }
    }

    public static String decodeString(String s) {
        String ans = "";
        Pointer i = new Pointer();

        while (i.val < s.length()) {
            char ch = s.charAt(i.val);
 //           System.out.println("+++" + ch);
            if (ch > '0' && ch < '9') {
                String num = "";// + ch;
                while (true) {
                    ch = s.charAt(i.val);
                    if(ch < '0' || ch > '9') break;
                    num += ch;
                    i.val++;
                }
                System.out.println("num " + num);
                int iNum = Integer.parseInt(num);
        //        System.out.println("-- " + ch);
                ans += stByN(inBrackets(s, i), iNum);//Character.getNumericValue(ch));
            }
            else if (ch == ']') {
                i.val++;
            }
            else {
                ans += ch;
                i.val++;
            }
            System.out.println("i " + i.val + ", char " + ch + " -- " + (i.val < s.length() ? s.charAt(i.val) : '&'));
        }
        return ans;
    }

    private static String inBrackets(String s, Pointer i) {
    //    i.val++;
        String ans = "";

        char ch = s.charAt(i.val);
        i.val++;

        while (ch != ']') {
            if (ch == ']' || i.val >=s.length() - 1) {
                return ans;
            }

            ch = s.charAt(i.val);
            if (ch == '[') {
                i.val ++;
                ch = s.charAt(i.val);
            }
            System.out.println("char: " + ch);
            if (ch > '0' && ch < '9') {
                String num = "";// + ch;
                while (true) {
                    ch = s.charAt(i.val);
                    if(ch < '0' || ch > '9') break;
                    num += ch;
                    i.val++;
                }
                System.out.println("num " + num);
                int iNum = Integer.parseInt(num);
                ans += stByN(inBrackets(s, i), iNum);//Character.getNumericValue(ch));
            } else if (ch == ']') {
             //   i.val++;
                return ans;
            }
            else {
                ans += ch;
            }
            i.val++;
        }
    //    System.out.println("returning from []: " + ans + ", i.val: " + i.val);
        return ans;
    }

    private static String stByN (String st, int n) {
        String ans = "";

        for (int j = 0; j < n; j++) {
            ans+=st;
        }
     //   System.out.println("return from for " + ans);
        return ans;
    }


    public static void main(String[] args) {
        String s = "4[ab]";
//        System.out.println(s);
//        System.out.println(decodeString(s));
//        s = "2[b3[a]]";
//        s = "2[abc]3[cd]ef";
//        s = "100[codesignal]";
        s = "sd2[f2[e]g]i";
        s = "10[0]";
        System.out.println(s);
        System.out.println("is: " + decodeString(s));
//        s = "z1[y]zzz2[abc]";
//        System.out.println(s);
//        System.out.println(decodeString(s) + " vs exp: zyzzzabcabc");
//
//        s = "2[a]3[b]4[c]5[d]";
//        System.out.println(s);
//        System.out.println(decodeString(s));

//        s = "3[a]2[bc]";
//        System.out.println(s);
//        System.out.println(decodeString(s));
    }
}

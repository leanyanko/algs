package com.company;

public class Binary {
    public static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        StringBuilder s = new StringBuilder();
        int carry = 0;
//        System.out.println(b.length());
        for (int i = 0; i < a.length(); i++) {
            int as = Character.getNumericValue(a.charAt(a.length() - i - 1));

            int bs = b.length() - i - 1 >= 0 ? Character.getNumericValue(b.charAt(b.length() - i - 1)) : 0;
            int digit = 0;

            System.out.println("as " + as);
      //      System.out.println("b " + b.charAt(b.length() - i - 1));
            System.out.println("bs " + bs);
            int check = as + bs + carry;
            System.out.println(check);

            if (check == 0) {
                carry = 0;
                digit = 0;
            }
            else if (check == 1) {
                carry = 0;
                digit = 1;
            }
            else if (check == 2){
                carry = 1;
                digit = 0;
            }
            else {
                carry = 1;
                digit = 1;
            }

            s.insert(0, digit);
        }
        if (carry == 1) s.insert(0, 1);
        return s.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
//        a = "11";
//        b = "1";
//        a = "1111";
//        b = "1111";
        a = "1";
        b = "111";
        System.out.println(addBinary(a, b));
    }
}

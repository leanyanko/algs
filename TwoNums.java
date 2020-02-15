package com.company;

public class TwoNums {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans;// = new ListNode(0);
        String an = "";
        long l_1 = getIntValue(l1);
        long l_2 = getIntValue(l2);
        long sum = l_1 + l_2;
        an = "" + sum;
        ans = new ListNode(Character.getNumericValue(an.charAt(0)));

        for (int i = 1; i < an.length(); i++) {
             ListNode tmp = ans;
             ans = new ListNode(Character.getNumericValue(an.charAt(i)));
             ans.next = tmp;
        }
        return ans;
    }

    private static long getIntValue (ListNode lis) {
        int i = 0;
        StringBuilder l = new StringBuilder();
        while(lis != null) {
            l.insert(0, lis.val);
            lis = lis.next;
        }
        return Long.parseLong(l.toString());
    }

//    private static int getIntValue (ListNode lis) {
//        int i = 0;
//        StringBuilder l = new StringBuilder();
//        while(lis != null) {
//            l.insert(0, lis.val);
//            lis = lis.next;
//        }
//        return Integer.parseInt(l.toString());
//    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);
    }
}

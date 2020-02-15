package com.company;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
        public ListNode(int x, ListNode next) { val = x; this.next = next;}
    }
    public static ListNode reverseList(ListNode head) {
        ListNode reversed = head;
        head = head.next;
        reversed.next = null;

        while(head != null) {
            ListNode next = head;
            head = head.next;
            ListNode tmp = reversed;
            reversed = next;
            reversed.next = tmp;
        }
        return reversed;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversed = reverseList(head);

        while(reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
}

package com.company;

public class AddLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            carry = (l1 != null ? l1.val : 0) +
                    (l2 != null ? l2.val : 0) +
                    carry;
            ListNode node = new ListNode(carry % 10);
            carry /= 10;

            if (head == null) {
                current = head = node ;
            }
            else {
                current.next = node;
                current = current.next;
            }

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return head;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;

        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            carry = (l1 != null ? l1.val : 0) +
                    (l2 != null ? l2.val : 0) +
                    carry;
            ListNode node = new ListNode (carry % 10);
            carry /= 10;

            if (head == null) {
                current = head = node;
            } else {
                current.next = node;
                current = current.next;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int num = sum >= 10 ? sum % 10 : sum;
        int reminder = sum >= 10 ? sum / 10 : 0;
        l1 = l1.next;
        l2 = l2.next;

        ListNode ans = new ListNode(num);
        ListNode pointer = ans;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + reminder;
            l1 = l1.next;
            l2 = l2.next;
            num = sum >= 10 ? sum % 10 : sum;
            reminder = sum / 10;
            ListNode nxt = new ListNode(num);
            pointer.next = nxt;
            pointer = pointer.next;
        }

        ListNode rem = l1 == null ? l2 : l1;

        pointer.next = rem == null? (reminder > 0 ? new ListNode(reminder) : null) : rem;

        while(reminder > 0 && rem != null) {
            sum = rem.val + reminder;
            num = sum >= 10 ? sum % 10 : sum;
            reminder = sum / 10;
            System.out.println(reminder);
            rem.val += num;
            rem = rem.next;
        }
        if (reminder > 0) rem = new ListNode(reminder);

        return ans;
    }


    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(8);
//        ListNode l2 = new ListNode(0);
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(1);

        ListNode ans = addTwoNumbers(l1, l2);
        System.out.println("---");
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
        System.out.println("end");
    }
}

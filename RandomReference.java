package com.company;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class RandomReference {

     private static class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
     }

    HashMap<RandomListNode, RandomListNode> visited = new HashMap<>();
    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;

        if (this.visited.containsKey(head)) return this.visited.get(head);

        RandomListNode node = new RandomListNode(head.label);
        this.visited.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    HashMap<RandomListNode, RandomListNode> visitedHash =
            new HashMap<RandomListNode, RandomListNode>();

    public RandomListNode copyRandomList3(RandomListNode head) {

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the cloned version of it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        // Create a new node with the label same as old node. (i.e. copy the node)
        RandomListNode node = new RandomListNode(head.label);
        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = this.copyRandomList2(head.next);
        node.random = this.copyRandomList2(head.random);

        return node;
    }


    public static RandomListNode copyRandomList0(RandomListNode head) {
        if (head == null) return null;
         RandomListNode filler = new RandomListNode(head.label);
         RandomListNode output = filler;
         filler.random = new RandomListNode(head.random.label);

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, filler);
        map.put(head.random, filler.random);
        head = head.next;

        while (head != null) {
            if (map.containsKey(head)) {
                filler.next = map.get(head);
            }
            else {
                filler.next = new RandomListNode(head.label);
                map.put(head, filler);
            }
            System.out.println("random " + head.random.label);
            if (map.containsKey(head.random)) {
                filler.next.random = map.get(head.random);
            }
            else {
                filler.next.random = new RandomListNode(head.random.label);
                map.put(head.random, filler.next.random);
            }
            head = head.next;
            filler = filler.next;
        }

         return output;
    }
//    public static RandomListNode copyRandomList(RandomListNode head) {
//         if (head == null) return null;
//         RandomListNode filler = new RandomListNode(head.label);
//         RandomListNode output = filler;
//         RandomListNode beginningHead = head;
//         head = head.next;
//
//         while (head != null) {
//             filler.next = new RandomListNode(head.label);
//             head = head.next;
//             filler = filler.next;
//         }
//
//        RandomListNode randomPointer = output;
//        filler = output;
//         head = beginningHead;
//
//         while(head != null) {
//
//             RandomListNode random = head.random;
//             System.out.println("random "+ random.label);
//             if (random == null) {
//                 filler.random = null;
//                 System.out.println("in null");
//             }
//             else {
//                 RandomListNode tmp = beginningHead;
//                 while(tmp != random) {
//                     System.out.println("tmp " + tmp.label);
//                     System.out.println(("pointer " + randomPointer.label));
//                     tmp = tmp.next;
//                     randomPointer = randomPointer.next;
//                 }
//                 filler.random = randomPointer;
//                 randomPointer = output;
//                 System.out.println("filler " + filler.random.label);
//             }
//
//             filler = filler.next;
//             head = head.next;
//         }
//
//        return output;
//    }

    private RandomListNode copyNode(RandomListNode old) {
        RandomListNode newNode = this.visited.containsKey(old) ? this.visited.get(old) : new RandomListNode(old.label);

        this.visited.put(old, newNode);

        return newNode;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
         if (head == null) return null;
         RandomListNode filler = copyNode(head);
         RandomListNode output = filler;
         filler.random = copyNode(head.random);
//         this.visited.put(head, filler);
//         head = head.next;


         while(head != null) {
             filler.next = copyNode(head);
             filler.next.random = copyNode(head.random);
             filler = filler.next;
             head = head.next;
         }

         return output;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(0);
        RandomListNode first = new RandomListNode(1);
        RandomListNode second = new RandomListNode(2);
        head.next = first;
        first.next = second;
        second.next = null;
        head.random = second;
        first.random = head;
        second.random = head;

        RandomReference ref = new RandomReference();
        RandomListNode ans = ref.copyRandomList(head);

        while(ans != null) {
            String next = ans.next != null ? ans.next.label + "" : "null";
            String rand = ans.random != null ? ans.random.label + "" : "null";
            System.out.println("label: " + ans.label + "; next: " + next + "; random: " + rand);
            ans = ans.next;
        }
    }
}

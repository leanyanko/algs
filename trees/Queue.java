package com.company.trees;

import java.util.PriorityQueue;

public class Queue {
    public static void main(String[] args) {

        PriorityQueue<Integer> queue= new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        queue.add(4);
        System.out.println(queue.poll());

    }
}



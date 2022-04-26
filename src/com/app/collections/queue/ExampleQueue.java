package com.app.collections.queue;

import java.util.PriorityQueue;

public class ExampleQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1000);
        queue.add(200);
        queue.add(5);
        queue.add(100);
        queue.add(8);
        queue.add(3);
        System.out.println("queue = " + queue);
    }
}

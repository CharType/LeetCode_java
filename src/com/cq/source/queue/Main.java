package com.cq.source.queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }

        while (!queue.isEmpty()) {
            System.out.printf(queue.deQueue().toString());
        }
    }
}

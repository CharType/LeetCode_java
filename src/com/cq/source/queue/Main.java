package com.cq.source.queue;

public class Main {
    public static void main(String[] args) {
        testDeQue();
    }


    public static void testDeQue() {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 5; i++) {
            deque.enQueueRear(i + 10);
            deque.enQueueFront(i + 11);
        }
        while (!deque.isEmpty()) {
            System.out.println(deque.deQueueFront());
        }
    }

    public static void testQueue() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }

        while (!queue.isEmpty()) {
            System.out.printf(queue.deQueue().toString());
        }
    }
}

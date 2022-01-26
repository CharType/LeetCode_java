package com.arithmetic.cq.source.queue;

import com.arithmetic.cq.source.queue.circle.CircleDeque;
import com.arithmetic.cq.source.queue.circle.CircleQueue;

public class Main {
    public static void main(String[] args) {
        testCircleDeque();
    }

    public static void testCircleDeque() {
        CircleDeque<Integer> queue = new CircleDeque();
        for (int i = 0; i < 15; i++) {
            queue.enQueueRear(i + 10);
            if (i > 10) {
                queue.enQueueFront(i);
            }
            System.out.println(queue);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue);
            System.out.println(queue.deQueueFront());
        }

    }

    public static void testCircleQueue() {
        CircleQueue<Integer> queue = new CircleQueue();
        for (int i = 0; i < 15; i++) {
            queue.enQueue(i + 10);
            if (i > 10) {
                queue.deQueue();
            }
        }
        System.out.println(queue);
//        while (!queue.isEmpty()) {
//            System.out.println(queue.deQueue());
//        }
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

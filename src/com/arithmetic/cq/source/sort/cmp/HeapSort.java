package com.arithmetic.cq.source.sort.cmp;

import com.arithmetic.cq.source.sort.Sort;

import java.util.PriorityQueue;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    private PriorityQueue<T> queue = new PriorityQueue();

    @Override
    protected void sort() {
        heapify();
        int index = array.length - 1;
        while (!queue.isEmpty()) {
            array[index] = queue.poll();
            index--;
        }
    }

    private void heapify() {
        for (int i = 0; i < array.length; i++) {
            queue.add(array[i]);
        }
    }
}

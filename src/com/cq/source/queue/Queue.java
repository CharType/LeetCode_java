package com.cq.source.queue;

import com.cq.source.list.LinkedList;
import com.cq.source.list.List;

public class Queue<E> {
    private List<E> list = new LinkedList<>();

    // 获取队列中元素的数量
    public int size() {
        return this.list.size();
    }

    // 判断队列是否是空
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    // 入队
    public void enQueue(E element) {
        this.list.add(0, element);
    }

    // 出队
    public E deQueue() {
        return this.list.remove(list.size() - 1);
    }

    // 获取队顶元素
    public E front() {
        return this.list.get(list.size() - 1);
    }

    // 清空元素
    public void clear() {
        this.list.clear();
        ;
    }
}

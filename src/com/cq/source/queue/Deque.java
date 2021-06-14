package com.cq.source.queue;

import com.cq.source.list.LinkedList;
import com.cq.source.list.List;

// 双端队列，能在头尾两端添加或者删除的队列
public class Deque<E> {
    private List<E> list = new LinkedList<>();

    // 获取队列中元素的数量
    public int size() {
        return this.list.size();
    }

    // 判断队列是否是空
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    // 从队尾部入队
    public void enQueueRear(E element) {
        this.list.add(list.size(), element);
    }

    // 从队头入队
    public void enQueueFront(E element) {
        this.list.add(0, element);
    }

    // 从队尾出队
    public E deQueueRear() {
        return this.list.remove(list.size() - 1);
    }

    // 从队头出队
    public E deQueueFront() {
        return this.list.remove(0);
    }

    // 获取队头元素
    public E front() {
        return this.list.get(0);
    }

    // 获取队尾部元素
    public E rear() {
        return this.list.get(list.size() - 1);
    }

    // 清空元素
    public void clear() {
        this.list.clear();
    }
}

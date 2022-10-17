package com.arithmetic.cq.source.queue.circle;

/**
 * 循环队列
 *
 * @param
 */
public class CircleQueue<E> {
    // 记录头元素的索引
    private int front;
    // 元素数量
    private int size;
    // 数组
    private E[] elements;
    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
    }

    // 入队
    public void enQueue(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    // 出队
    public E deQueue() {
        E oldemelent = elements[index(front)];
        elements[index(front)] = null;
        front = index(1);
        size--;
        return oldemelent;
    }

    // 保证要有 capacity 个容量
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        int newCapacity = (oldCapacity >> 1) + oldCapacity;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front = 0;
    }

    // 获取队顶元素
    public E front() {
        return elements[index(front)];
    }

    private int index(int index) {
        index += front;
        index = index % elements.length;
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=" + size).append(",").append("front=" + front).append("  [");
        for (int i = 0; i < size; i++) {
            sb.append(elements[index(i)]);
            if (i < size - 1) {
                sb.append(" ,");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

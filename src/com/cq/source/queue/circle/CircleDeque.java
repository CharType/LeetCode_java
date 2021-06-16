package com.cq.source.queue.circle;

/**
 * 循环双端队列
 *
 * @param
 */
public class CircleDeque<E> {
    // 记录头元素的索引
    private int front;
    // 元素数量
    private int size;
    // 数组
    private E[] elements;
    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
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

    // 从队尾部入队
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    // 从队尾部出队
    public E deQueueRear() {
        E oldemelent = elements[index(front)];
        elements[index(front)] = null;
        front = index(1);
        size--;
        return oldemelent;
    }

    // 从队头入队
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    // 从队头部出队
    public E deQueueFront() {
        E oldemelent = elements[index(front)];
        elements[index(front)] = null;
        front = index(1);
        size--;
        return oldemelent;
    }

    // 获取队列头元素
    public E front() {
        return null;
    }

    // 获取队尾部顶元素
    public E rear() {
        return elements[index(front)];
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

    private int index(int index) {
        index += front;
        index = index % elements.length;
        System.out.println("计算出index=" + index);
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

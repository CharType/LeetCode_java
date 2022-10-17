package com.arithmetic.cq.source.list.array;

import com.arithmetic.cq.source.list.AbstractList;

public class ArrayList<E> extends AbstractList<E> {
    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;
    // 存储所有的元素
    private E[] elements;

    // 记录挪动数据次数
    private int moveCount = 0;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        this.elements = (E[]) new Object[capacity];
    }

    @Override
    public void clear() {
        // 清空还是创建一块新的内存？
        this.elements = (E[]) new Object[this.elements.length];
        size = 0;
        trimCapacityCheck();
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        if (index != size) {
            for (int i = size; i > index; i--) {
                moveCount++;
                elements[i] = elements[i - 1];
            }
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        // 判断是否需要进行扩容操作
        if (capacity < oldCapacity) return;

        // 新的数组容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    private void trimCapacityCheck() {
        // 缩容设计
        int oldCapacity = elements.length;
        // 如果size == 0 直接给默认容量
        if (size == 0 && elements.length > DEFAULT_CAPACITY) {
            System.out.println("size =" + size + "容量：" + oldCapacity + "缩容为：" + DEFAULT_CAPACITY);
            elements = (E[]) new Object[DEFAULT_CAPACITY];
            return;
        }
        // 如果size 大于容量的一半，不需要缩容
        if (size > (oldCapacity >> 1)) return;
        // 新的容量等于size的1。5倍
        int newCapacity = ((size >> 1) + size);
        // 如果计算出新的容量,取默认容量
        newCapacity = (newCapacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : newCapacity;
        // 如果计算出的新的容量和之前的容量相等，取消缩容
        if (newCapacity == oldCapacity) return;
        // 申请新的内存，缩容
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("size =" + size + "容量：" + oldCapacity + "缩容为：" + newCapacity);
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldElement = elements[index];
        for (int i = index; i < size; i++) {
            moveCount++;
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size] = null;
        trimCapacityCheck();
        return oldElement;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(" ,");
            }
        }
        sb.append("]");
        sb.append("\n");
        sb.append("挪动数据次数：" + moveCount);
        return sb.toString();
    }
}

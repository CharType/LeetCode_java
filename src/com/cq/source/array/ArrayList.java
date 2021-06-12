package com.cq.source.array;

import com.cq.source.AbstractList;

public class ArrayList<E> extends AbstractList<E> {
    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;
    // 存储所有的元素
    private E[] elements;
    // 当前数组的容量
    private int capacity;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        this.capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        this.elements = (E[]) new Object[capacity];
    }

    @Override
    public void clear() {
        // 清空还是创建一块新的内存？
        this.elements = (E[]) new Object[this.capacity];
        size = 0;
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

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


}

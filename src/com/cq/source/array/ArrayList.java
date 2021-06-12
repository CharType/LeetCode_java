package com.cq.source.array;

import com.cq.source.AbstractList;

public class ArrayList<E> extends AbstractList<E> {
    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;
    // 存储所有的元素
    private E[] elements;

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

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldElement = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size] = null;
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
        return sb.toString();
    }
}

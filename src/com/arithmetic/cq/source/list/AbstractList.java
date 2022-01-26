package com.arithmetic.cq.source.list;

public abstract class AbstractList<E> implements List<E> {
    /**
     * 元素的数量
     */
    protected int size;

    /**
     * 获取元素的数量
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     *
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * 抛出越界异常
     *
     * @param index
     */
    protected void outofBounds(int index) {
        throw new IndexOutOfBoundsException("Index: " + index + "Size:" + size);
    }

    /**
     * 普通的异常检测
     *
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outofBounds(index);
        }
    }

    /**
     * 添加元素时候的异常检测
     *
     * @param index
     */
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outofBounds(index);
        }
    }
}

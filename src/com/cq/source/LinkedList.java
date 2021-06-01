package com.cq.source;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    /**
     * 获取链表指定索引的元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 设置链表指定索引的元素
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, Object element) {
        return null;
    }

    /**
     * 在指定的索引添加元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, Object element) {

    }

    /**
     * 删除指定索引的元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * 获取指定元素的索引
     *
     * @param element
     * @return
     */
    @Override
    public int indexof(Object element) {
        return 0;
    }

    /**
     * 根据index 获取对应的节点
     *
     * @param index
     * @return
     */
    private Node<E node(int index) {
        rangeCheck(index);

        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }

    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev) {
            this.element = element;
            this.prev = prev;
        }
    }
}

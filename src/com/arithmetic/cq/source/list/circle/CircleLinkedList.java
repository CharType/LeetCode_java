package com.arithmetic.cq.source.list.circle;

import com.arithmetic.cq.source.list.AbstractList;

/**
 * 双向循环链表
 *
 * @param <E>
 */
public class CircleLinkedList<E> extends AbstractList<E> {
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
    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement;
        if (index == 0) {
            oldElement = first.element;
            first.element = element;
        } else if (index == size) {
            oldElement = last.element;
            last.element = element;
        } else {
            Node<E> node = node(index);
            oldElement = node.element;
            node.element = element;
        }
        return oldElement;
    }

    /**
     * 在指定的索引添加元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == size) {
            // 往最后面添加
            Node oldLast = last;
            Node<E> newNode = new Node<>(last, element, first);
            if (oldLast == null) {
                // 第一次添加数据
                first = newNode;
                newNode.next = newNode;
                newNode.prev = newNode;
            } else {
                last.next = newNode;
                newNode.next = first;
                first.prev = newNode;
            }
            last = newNode;
        } else if (index == 0) {
            Node<E> newNode = new Node<>(first.prev, element, first);
            first.prev = newNode;
            last.next = newNode;
            first = newNode;
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            if (prev == null) {
                first = node;
            } else {
                prev.next = node;
                next.prev = node;
            }
        }
        size++;
    }

    /**
     * 删除指定索引的元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (node == last) {
            // 删除最后一个元素
            prev.next = next;
            next.prev = prev;
            last = prev;
        } else if (node == first) {
            // 删除的是第一个元素
            prev.next = next;
            next.prev = prev;
            first = next;
        } else {
            // 删除的是中间的元素
            prev.next = next;
            next.prev = prev;
        }

        size--;
        return node.element;
    }

    /**
     * 获取指定元素的索引
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        Node node = first;
        int index = 0;
        while (node != null) {
            if (node.element.equals(element)) {
                return index;
            }
            node = node.next;
            index++;
            if (index >= size) {
                break;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * 根据index 获取对应的节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", [");
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(node);
            node = node.next;
        }
        sb.append(']');
        return sb.toString();
    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }

            sb.append("_").append(element).append("_");

            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }

            return sb.toString();
        }
    }
}

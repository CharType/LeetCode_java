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
            Node<E> newNode = new Node<>(last, element, null);
            if (oldLast == null) {
                // 第一次添加数据
                first = newNode;
            } else {
                last.next = newNode;
            }
            last = newNode;

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
        node.prev.next = node.next;
        node.next.prev = node.prev;
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
    public int indexof(E element) {
        Node node = first;
        int index = 0;
        while (node != null) {
            if (node.element.equals(element)) {
                break;
            }
            node = node.next;
            index++;
        }
        if (index < size) {
            return index;
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
        sb.append('[');
        Node node = first;
        while (node != null) {
            sb.append(' ' + node.element.toString() + ' ');
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

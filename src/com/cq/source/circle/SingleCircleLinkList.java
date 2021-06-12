package com.cq.source.circle;

import com.cq.source.AbstractList;

public class SingleCircleLinkList<E> extends AbstractList<E> {
    Node<E> first;

    @Override
    public void clear() {
        size = 0;
        first.next = null;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            if (first == null) {
                first = new Node<>(element, null);
                first.next = first;
            } else {
                Node<E> last = node(size - 1);
                Node<E> newNode = new Node<>(element, first);
                first = newNode;
                last.next = newNode;
            }
        } else if (index == size) {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, first);
        } else {
            Node<E> next = node(index);
            Node<E> prev = node(index - 1);
            Node<E> newNode = new Node<>(element, next);
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldElement = null;
        if (index == 0) {
            oldElement = first.element;
            Node<E> last = node(size - 1);
            first = first.next;
            last.next = first;
        } else if (index == (size - 1)) {
            Node<E> prev = node(index - 1);
            oldElement = prev.next.element;
            prev.next = first;
        } else {
            Node<E> prev = node(index - 1);
            oldElement = prev.next.element;
            prev.next = prev.next.next;
        }


        size--;
        return oldElement;
    }

    @Override
    public int indexOf(E element) {
        Node<E> tempNode = first;
        int index = ELEMENT_NOT_FOUND;
        while (tempNode != null) {
            index++;
            if (index == size) {
                break;
            }
            if (tempNode.element.equals(element)) {
                return index;
            }
            tempNode = tempNode.next;
        }
        return ELEMENT_NOT_FOUND;
    }

    public Node<E> node(int index) {
        rangeCheck(index);
        Node<E> tempNode = first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                break;
            }
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        int index = 0;
        Node<E> node = first;
        while (index < size) {
            index++;
            sb.append(node);
            node = node.next;
            if (index < size) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("_").append(element.toString()).append("_").append(next.element.toString()).append("_");
            return sb.toString();
        }
    }
}

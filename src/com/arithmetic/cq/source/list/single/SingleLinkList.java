package com.arithmetic.cq.source.list.single;

import com.arithmetic.cq.source.list.AbstractList;

public class SingleLinkList<E> extends AbstractList<E> {
    Node<E> first;

    @Override
    public void clear() {
        size = 0;
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
            } else {
                Node<E> newNode = new Node<>(element, first);
                first = newNode;
            }
        } else if (index == size) {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, null);
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
            first = first.next;
        } else if (index == (size - 1)) {
            Node<E> prev = node(index - 1);
            oldElement = prev.next.element;
            prev.next = null;
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

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}

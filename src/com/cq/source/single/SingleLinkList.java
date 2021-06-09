package com.cq.source.single;

import com.cq.source.AbstractList;

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

            } else {
    
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = node(index - 1);
            Node<E> newNode = new Node<>(element, next);
            prev.next = newNode;
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexof(E element) {
        Node<E> tempNode = first;
        int index = ELEMENT_NOT_FOUND;
        while (tempNode != null) {
            index++;
            if (tempNode.element.equals(element)) {
                break;
            }
            tempNode = tempNode.next;
        }
        return index;
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

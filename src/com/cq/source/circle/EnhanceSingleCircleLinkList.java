package com.cq.source.circle;

import com.cq.source.AbstractList;

/**
 * 增强型单向循环链表
 *
 * @param <E>
 */
public class EnhanceSingleCircleLinkList<E> extends AbstractList<E> {
    // 指向头结点的指针
    Node<E> first;
    // 用来指向某个节点
    Node<E> current;

    // 重置current指针，指向头结点
    public void reset() {
        current = first;
    }

    // 让current指针往后走一步，并且返回下一个内容
    public E next() {
        System.out.println("当前节点 =" + current.element);
        current = current.next;
        return current.element;
    }

    // 删除current指向的节点，删除成功后让current指向下一个节点
    public E remove() {
        E oldement = remove(current);
        if (size == 0) {
            current = null;
            return oldement;
        }
        next();
        return oldement;
    }

    private E remove(Node<E> node) {
        E oldElement = node.element;
        if (size == 1) {
            clear();
        } else if (node == first) {
            // 删除的是头结点
            Node<E> last = node(size - 1);
            first = first.next;
            last.next = first;
            size--;
        } else {
            Node<E> prev = node(indexOf(node.element) - 1);
            prev.next = node.next;
            size--;
        }
        return oldElement;
    }


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
        Node<E> node = node(index);
        return remove(node);
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

        @Override
        protected void finalize() throws Throwable {
            System.out.println(this + "被销毁了");
            super.finalize();
        }
    }
}

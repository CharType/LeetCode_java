package com.cq.source.tree;

import com.TreeNode.printer.BinaryTreeInfo;

public class BinaryTree<E> implements BinaryTreeInfo {
    protected int size;
    protected Node<E> root;


    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E emelent, Node<E> parent) {
            this.element = emelent;
            this.parent = parent;
        }
        
    }

    @Override
    public Object root() {
        return null;
    }

    @Override
    public Object left(Object node) {
        return null;
    }

    @Override
    public Object right(Object node) {
        return null;
    }

    @Override
    public Object string(Object node) {
        return null;
    }
}

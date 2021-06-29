package com.cq.source.search.tree;

import com.TreeNode.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<E> implements BinaryTreeInfo {

    // 一共有多少个节点
    private int size;
    // 根节点
    private Node<E> root;
    // 比较强
    private Comparator<E> comparator;

    // 构造方法
    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    // 获取节点数量
    public int size() {
        return size;
    }

    // 搜索树是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 清空
    public void clear() {
        size = 0;
        root = null;
    }

    // 添加数据
    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        // 先找父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                // 相等
                node.element = element;
                return;
            }
        }
        Node newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public void remove(E element) {
        remove(node(element));
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    private void remove(Node<E> node) {
        if (node == null) return;
        size--;
        // 是否是度为2的节点
        if (node.hasTwoChildren()) {
            // 找到后继节点
        }

    }

    //-----------------------遍历--------------------------------start

    // 使用迭代方式前序遍历
    public void preorderTraversalStack() {
        if (root == null) return;
        Stack<Node<E>> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node<E> node = stack.pop();
            System.out.println(node.element);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }

        }
    }

    public void preorderTraversal() {
        preorder(root);
    }

    //前序遍历，先访问跟节点，然后左节点，右节点，
    private void preorder(Node<E> node) {
        if (node == null) return;
        System.out.println(node.element);
        preorder(node.left);
        preorder(node.right);
    }

    public void inorderTraversalStack() {
        if (root == null) return;
        Stack<Node<E>> stack = new Stack<>();
        Node<E> tempNode = root;
        while (tempNode != null || !stack.isEmpty()) {
            if (tempNode != null) {
                stack.add(tempNode);
                tempNode = tempNode.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    tempNode = stack.pop();
                    System.out.println(tempNode.element);
                    tempNode = tempNode.right;
                }
            }
        }
    }

    // 递归方式
    public void inorderTraversal() {
        inorder(root);
    }

    // 中序遍历，根节点在中间，访问顺序 左节点，跟节点，右节点 对于二叉搜索树来说得到的顺序树升序
    // 如果按照 右节点，根节点 左节点访问 得到的顺序就是倒序
    private void inorder(Node<E> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.element);
        inorder(node.right);
    }


    public void postOrderTraversal() {
        postOrder(root);
    }

    // 后续遍历，先访问左节点，在访问右节点，最后访问根节点
    private void postOrder(Node<E> node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.element);
    }

    public void levelOrderTraversal() {
        levelOrder(root);
    }

    // 层序遍历
    private void levelOrder(Node<E> node) {
        if (node == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node tempNode = queue.remove();
            System.out.println(tempNode.element);
            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
        }
    }

    //-----------------------end--------------------------

    // 查找element对应的节点
    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }

        return ((Comparable<E>) e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }
}

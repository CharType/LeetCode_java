package com.cq.source.search.tree;

import com.TreeNode.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class BinaryTree<E> implements BinaryTreeInfo {
    // 一共有多少个节点
    protected int size;
    // 根节点
    protected Node<E> root;


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

    // 获取前驱节点
    protected Node<E> predecessor(Node<E> node) {
        if (node == null) return null;
        // 如果左子树不等于null，那么前驱节点一定在左子树中
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 左子树等于空，那么前驱节点一定在父节点或者父节点之上
        // node.parent == null 直接返回null
        // node == node.parent.right 找到右节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    // 获取后继节点
    protected Node<E> successor(Node<E> node) {
        if (node == null) return null;
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    //-----------------------遍历--------------------------------start

    // 使用迭代方式前序遍历
    public void preorderTraversalStack(Visitor visitor) {
        if (root == null || visitor == null) return;
        Stack<Node<E>> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node<E> node = stack.pop();
            visitor.stop = visitor.visit(node.element);
            if (visitor.stop) {
                break;
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }

        }
    }

    public void preorderTraversal(Visitor visitor) {
        if (visitor == null) return;
        preorder(root, visitor);
    }

    //前序遍历，先访问跟节点，然后左节点，右节点，
    private void preorder(Node<E> node, Visitor visitor) {
        if (node == null || visitor.stop == true) return;
        visitor.stop = visitor.visit(node.element);
        preorder(node.left, visitor);
        preorder(node.right, visitor);
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
    protected void inorder(Node<E> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.element);
        inorder(node.right);
    }

    // 后续遍历，非递归
    //todo:待完善
    public void postOrderTraversalStack() {
        if (root == null) return;
        Stack<Node<E>> stack = new Stack<>();
        stack.add(root);
        boolean lastIsLeaf = false;
        while (!stack.isEmpty()) {
            Node<E> node = stack.peek();
            if (node.isLeaf() || lastIsLeaf) {
                lastIsLeaf = true;
                System.out.println(stack.pop().element);
            } else {
                lastIsLeaf = false;
                if (node.right != null) {
                    stack.add(node.right);
                } else if (node.left != null) {
                    stack.add(node.left);
                } else {
                    System.out.println(stack.pop().element);
                }
            }

        }
    }

    public void postOrderTraversal() {
        postOrder(root);
    }

    // 后续遍历，先访问左节点，在访问右节点，最后访问根节点
    protected void postOrder(Node<E> node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.element);
    }

    public void levelOrderTraversal() {
        levelOrder(root);
    }

    // 层序遍历
    protected void levelOrder(Node<E> node) {
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

    public boolean isComplete() {
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean islaef = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (islaef && !node.isLeaf()) return false;
            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                islaef = true;
            }
        }
        return true;
    }

    public int height2() {
        if (root == null) return 0;
        Queue<Node<E>> queue = new LinkedList<>();
        int height = 0;
        int level = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.remove();
            level--;
            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
            if (level == 0) {
                height++;
                level = queue.size();
            }
        }
        return height;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }

    public void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) return;

        sb.append(prefix).append(node.element).append('\n');
        toString(node.left, sb, prefix + "L---");
        toString(node.right, sb, prefix + "R---");
    }


    protected static class Node<E> {
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

    public static abstract class Visitor<E> {
        boolean stop = false;

        public abstract boolean visit(E element);
    }
}

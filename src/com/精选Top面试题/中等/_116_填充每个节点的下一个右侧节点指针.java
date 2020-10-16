package com.精选Top面试题.中等;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 层序遍历
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class _116_填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        root.next = null;
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        _116_填充每个节点的下一个右侧节点指针 o= new _116_填充每个节点的下一个右侧节点指针();

    }
}

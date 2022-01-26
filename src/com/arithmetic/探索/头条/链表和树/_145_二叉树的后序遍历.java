package com.arithmetic.探索.头条.链表和树;

import com.arithmetic.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 后续遍历先遍历左节点，在遍历右节点，在遍历根节点
 */
public class _145_二叉树的后序遍历 {
    private List<Integer> list = new ArrayList<>();
    // 递归版本
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
    // 非递归版本
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> outStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                outStack.push(node);
                node = node.right;
            } else  {
                node = stack.pop();
                node = node.left;
            }
        }

        while (!outStack.isEmpty()) {
            list.add(outStack.pop().val);
        }
        return list;
    }

    public static void main(String[] args) {
        _145_二叉树的后序遍历 o = new _145_二叉树的后序遍历();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(o.postorderTraversal(root));
        System.out.println(o.postorderTraversal1(root));
    }
}

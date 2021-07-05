package com.cq.source.tree.leetcode;

import com.TreeNode.TreeNode;
import com.TreeNode.printer.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _145_二叉树的后序遍历 {

    //迭代
    public List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode oldNode = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if ((node.left == null && node.right == null) || (oldNode != null && (node.left == oldNode || node.right == oldNode))) {
                oldNode = stack.pop();
                list.add(oldNode.val);
            } else {
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
        }
        return list;
    }

    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    public void postorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        postorderTraversal(node.left, list);
        postorderTraversal(node.right, list);
        list.add(node.val);
    }

    public static void main(String[] args) {
        _145_二叉树的后序遍历 o = new _145_二叉树的后序遍历();
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);

//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        BinaryTrees.print(root);
        System.out.println('\n');
//        System.out.println(o.postorderTraversal(root));
//        System.out.println('\n');
        System.out.println(o.postorderTraversalStack(root));
    }


}

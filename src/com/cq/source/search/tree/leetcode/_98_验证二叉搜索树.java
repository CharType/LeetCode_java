package com.cq.source.search.tree.leetcode;

import com.TreeNode.TreeNode;
import com.TreeNode.printer.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class _98_验证二叉搜索树 {
    // 递归解法
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 访问左子树，如果左子树验证不合法 
        if (!isValidBST(root.left)) return false;

        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    public boolean isValidBSTStack(TreeNode root) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    TreeNode tempNode = stack.pop();
                    list.add(tempNode.val);
                    node = tempNode.right;
                }
            }
        }
        System.out.println(list.toString());
        if (list.size() == 1) return true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _98_验证二叉搜索树 o = new _98_验证二叉搜索树();
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(8);

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        BinaryTrees.print(root);
        System.out.println('\n');
        System.out.println(o.isValidBST(root));
    }
}

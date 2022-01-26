package com.arithmetic.探索.快手;

import com.arithmetic.TreeNode.TreeNode;

import java.util.Stack;

public class _98_验证二叉搜索树 {
    private boolean isvalBST = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            if(root.left.val < root.val) {
                isValidBST(root.left);
            } else {
                isvalBST = false;
            }
        }
        if (root.right != null) {
            if(root.right.val > root.val) {
                isValidBST(root.right);
            } else {
                isvalBST = false;
            }
        }
        return isvalBST;
    }

    /**
     *过段时间在刷一遍
     * @return
     */
    public boolean helper(TreeNode node,Integer lower,Integer upper) {
        if (node == null) return true;
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        if (!helper(node.right,val,upper)) return false;
        if (!helper(node.left,lower,val)) return false;
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        return helper(root, null, null);
    }

    // 使用中序遍历来判断是否是二叉搜索树
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastNode = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            if (lastNode == null) {
                lastNode = node;
            } else {
                if (lastNode.val >= node.val) {
                    return false;
                }
                lastNode = node;
            }
            node = node.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(4);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(7);
//        rootNode.right.left = new TreeNode(10);
        rootNode.left.left = new TreeNode(1);
        rootNode.left.right = new TreeNode(3);

        TreeNode rootNode1 = new TreeNode(10);
        rootNode1.left = new TreeNode(5);
        rootNode1.right = new TreeNode(15);
//        rootNode.right.left = new TreeNode(10);
        rootNode1.right.left = new TreeNode(6);
        rootNode.right.right = new TreeNode(20);
        _98_验证二叉搜索树 o = new _98_验证二叉搜索树();
//        System.out.println(o.isValidBST(rootNode1));
//        System.out.println(o.isValidBST2(rootNode1));

        TreeNode rootNode3 = new TreeNode(1);
        rootNode3.left = new TreeNode(1);
        System.out.println(o.isValidBST2(rootNode3));
    }

}

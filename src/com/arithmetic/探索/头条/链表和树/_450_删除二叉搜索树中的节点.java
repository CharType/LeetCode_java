package com.arithmetic.探索.头条.链表和树;

import com.arithmetic.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class _450_删除二叉搜索树中的节点 {

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;

            if (key < root.val) {
                // 要删除的节点在左子树上
                root.left = deleteNode(root.left,key);
            } else if (key > root.val) {
                // 要删除的节点在右子树上
                root.right = deleteNode(root.right,key);
            } else {
                // 找到了要删除的节点
                if (root.left == null) {
                    // 如果左子树为空就只返回右子树
                    return root.right;
                }
                if (root.right == null) {
                    // 如果右子树为空，只返回左子树
                    return root.left;
                }
                // 查找到前驱节点，替换当前节点
                TreeNode maxNode = findMax(root.left);
                root.val = maxNode.val;
                // 删除前驱节点
                root.left = deleteNode(root.left, root.val);
            }
            return root;
        }

        private TreeNode findMax(TreeNode node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }

    public static void main(String[] args) {
        _450_删除二叉搜索树中的节点 o = new _450_删除二叉搜索树中的节点();
//        TreeNode rootNode = new TreeNode(5);
//        rootNode.left = new TreeNode(3);
//        rootNode.right = new TreeNode(6);
//        rootNode.left.left = new TreeNode(2);
//        rootNode.left.right = new TreeNode(4);
//        rootNode.right.right = new TreeNode(7);
        TreeNode rootNode = new TreeNode(1);
        rootNode.right = new TreeNode(2);
        o.deleteNode(rootNode,2);
        System.out.println(rootNode);
    }
}

package com.arithmetic.精选Top面试题.中等;

import com.arithmetic.TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 前序遍历 先遍历根节点，在递归遍历左节点，在递归遍历右节点
 * 中序遍历 先递归遍历左子树，遍历根节点，最后遍历右节点
 * 利用前序遍历和中序遍历的特性来恢复这颗二叉树
 */
public class _105_从前序与中序遍历序列构造二叉树 {

    // 迭代解法 多看看
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        // 前序遍历先遍历根节点，直接先创建出根节点
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inoderIndex = 0;
        for (int i = 1;i < preorder.length;i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inoderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inoderIndex]) {
                    node = stack.pop();
                    inoderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

        // 递归解法
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0;i < n;i++) {
            indexMap.put(inorder[i],i);
        }
        return myBuildTreee(preorder,inorder,0,n - 1,0,n - 1);
    }

    /**
     *
     * @param preorder 前序遍历数组数据
     * @param inorder  中序遍历数组数据
     * @param preorder_left
     * @param preorder_right
     * @param inoder_left
     * @param inoder_right
     * @return
     */
    public TreeNode myBuildTreee(int [] preorder,int [] inorder,int preorder_left,int preorder_right,int inoder_left,int inoder_right) {
        if (preorder_left > preorder_right) {
            // 左节点如果大于右节点的索引，直接返回null
            return null;
        }
        // 前序遍历中的第一个节点都是跟节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位跟节点的索引位置
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 构建根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 先得到左子树中的节点数量（用中序遍历root节点的位置 - 中序遍历左节点的位置，就得到左子树的所有节点个数）
        int size_left_subtree = inorder_root - inoder_left;
        // 递归构造左子树，并且连接到根节点
        // 前序遍历中从左边边界+1 开始 size_left_subtree 个元素就对应了中序遍历中从左边界开始到根节点定位-1的元素
        root.left = myBuildTreee(preorder,inorder,preorder_left + 1,preorder_left + size_left_subtree, inoder_left,inorder_root - 1);
        // 递归构造右子树，并且连接到根节点
        // 先遍历中【从左边界 + 1 + 左节点数目 开始 到 右边界】的元素就对应了中序遍历中【从根节点定位  +1 到右边界】的元素
        root.right = myBuildTreee(preorder,inorder,preorder_left+size_left_subtree+1,preorder_right,inorder_root+1,inoder_right);
        return root;
    }

    public static void main(String[] args) {
        _105_从前序与中序遍历序列构造二叉树 o = new _105_从前序与中序遍历序列构造二叉树();
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        TreeNode node = o.buildTree2(preorder,inorder);
//        BinaryTrees.print(node);

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

    }
}

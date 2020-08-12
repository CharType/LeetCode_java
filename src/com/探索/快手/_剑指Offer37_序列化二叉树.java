package com.探索.快手;

import com.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _剑指Offer37_序列化二叉树 {

    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0;i < len;i++) {
                TreeNode node = queue.remove();
                if (node != null) {
                    sb.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    sb.append("null,");
                }

            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 3) return null;
         String [] str = data.substring(1,data.length()-2).split(",");
        System.out.println(str);
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
          TreeNode node = queue.remove();
          if (!str[i].equals("null")) {
              node.left = new TreeNode(Integer.parseInt(str[i]));
              queue.add(node.left);
          }
          i++;
          if (!str[i].equals("null")) {
              node.right = new TreeNode(Integer.parseInt(str[i]));
              queue.add(node.right);
          }
        }
         return root;
    }

    public static void main(String[] args) {
        _剑指Offer37_序列化二叉树 o = new _剑指Offer37_序列化二叉树();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(o.serialize(root));
//        TreeNode newNode = o.deserialize(o.serialize(root));

    }
}

package com.cq.source.search.tree;

import com.TreeNode.printer.BinaryTrees;
import com.tools.Integers;

public class Main {
    public static void main(String[] args) {

//        preorder();
        inOrder();
    }

    public static void levelOrder() {
        BinarySearchTree bst = new BinarySearchTree();
        Integer data[] = Integers.random(10, 0, 100);
        Integers.println(data);
        System.out.println('\n');
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.print(bst);
        System.out.println('\n');
        bst.levelOrderTraversal();
    }

    public static void postOrder() {
        BinarySearchTree bst = new BinarySearchTree();
        Integer data[] = Integers.random(10, 0, 100);
        Integers.println(data);
        System.out.println('\n');
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.print(bst);
        System.out.println('\n');
        bst.postOrderTraversal();
    }

    public static void inOrder() {
        BinarySearchTree bst = new BinarySearchTree();
        Integer data[] = Integers.random(10, 0, 100);
        Integers.println(data);
        System.out.println('\n');
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.print(bst);
        System.out.println('\n');
//        bst.inorderTraversal();
//        System.out.println('\n');
        bst.inorderTraversalStack();
    }

    // 前序遍历
    public static void preorder() {
        BinarySearchTree bst = new BinarySearchTree();
        Integer data[] = Integers.random(10, 0, 100);
        Integers.println(data);
        System.out.println('\n');
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.print(bst);
        System.out.println('\n');
        bst.preorderTraversal();
        System.out.println('\n');
        bst.preorderTraversalStack();
    }
}

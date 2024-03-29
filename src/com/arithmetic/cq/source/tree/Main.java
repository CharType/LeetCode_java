package com.arithmetic.cq.source.tree;

import com.arithmetic.TreeNode.printer.BinaryTrees;
import com.arithmetic.tools.Integers;

public class Main {
    public static void main(String[] args) {

//        test2();
        preorder();
        inOrder();
        postOrder();
    }

    public static void test2() {
        // 删除度为2 的节点
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);

        bst.remove(2);

        BinaryTrees.println(bst);
    }


    public static void test1() {
        // 删除根节点
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);

        bst.remove(7);

        BinaryTrees.println(bst);
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
        System.out.println('\n');
//        bst.postOrderTraversalStack();
    }

    public static void inOrder() {
        BinarySearchTree bst = new BinarySearchTree();
//        Integer data[] = Integers.random(10, 0, 100);
        Integer data[] = new Integer[]{7, 4, 9, 2, 5};
        Integers.println(data);
        System.out.println('\n');
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.print(bst);
        System.out.println('\n');
        bst.inorderTraversal();
        System.out.println('\n');
        bst.inorderTraversalStack();
        System.out.println('\n');
        System.out.println("递归方式获取二叉树高度:" + bst.height());
        System.out.println('\n');
        System.out.println("层序遍历方式获取二叉树高度:" + bst.height2());
        System.out.println('\n');
        System.out.println("是否是一个满二叉树" + bst.isComplete());
    }

    // 前序遍历
    public static void preorder() {
        BinarySearchTree bst = new BinarySearchTree();
        Integer data[] = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        Integers.println(data);
        System.out.println('\n');
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.print(bst);
        System.out.println('\n');

        System.out.println(bst);
        return;
//        bst.preorderTraversal(new Visitor<Integer>() {
//
//            @Override
//            public boolean visit(Integer element) {
//                System.out.println(element);
//                if (element == 1) return true;
//                return false;
//            }
//        });
//        System.out.println('\n');
//        bst.preorderTraversalStack(new Visitor<Integer>() {
//            @Override
//            public boolean visit(Integer element) {
//                System.out.println(element);
//                if (element == 1) return true;
//                return false;
//            }
//        });
    }
}

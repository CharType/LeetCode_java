package com.arithmetic.cq.source.heap;

import com.arithmetic.TreeNode.printer.BinaryTrees;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        test2();
        System.out.println('\n');
        System.out.println('\n');
        System.out.println('\n');
        test3();
    }

    static void test2() {
        Integer[] data = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data);
        BinaryTrees.println(heap);


        BinaryTrees.println(heap);
    }

    static void test3() {
        Integer[] data = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        BinaryTrees.println(heap);
    }
}

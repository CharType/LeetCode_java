package com.cq.source.sort;

import com.cq.source.sort.cmp.*;
import com.tools.Asserts;
import com.tools.Integers;

public class MainTest {
    public static void main(String[] args) {
        Integer[] array = Integers.random(100000, 0, 1000000);
//        Integer[] array = Integers.tailAscOrder(1, 10000, 1000);
//        Integer[] array = Integers.same(50000, 0);
        tetsSort(array,
                new BubbleSort1<Integer>(),
                new BubbleSort2<Integer>(),
                new BubbleSort3<Integer>(),
                new SelectionSort<Integer>(),
                new SelectionSort1<Integer>(),
                new HeapSort<Integer>(),
                new InsertionSort<Integer>(),
                new InsertionSort2<Integer>(),
                new InsertionSort3<Integer>(),
                new MergeSort<Integer>(),
                new QuickSort<Integer>(),
                new ShellSort<Integer>(),
                new CountingSort(),
                new CountingSort1()
        );

    }

    public static void testBinarySearch() {
        int[] nums = {2, 5, 3, 7, 10, 9, 6};
        Asserts.test(BinarySearch.search(nums, 2) == 0);
        Asserts.test(BinarySearch.search(nums, 5) == 1);
        Asserts.test(BinarySearch.search(nums, 10) == 4);
        Asserts.test(BinarySearch.search(nums, 6) == 6);
        Asserts.test(BinarySearch.search(nums, 20) == -1);
    }

    public static void tetsSort(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
//            Integers.println(newArray);
            sort.sort(newArray);
//            Integers.println(newArray);
            Asserts.test(Integers.isAscOrder(newArray) || Integers.isDescOrder(newArray));
        }

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}

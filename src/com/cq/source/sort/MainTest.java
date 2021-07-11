package com.cq.source.sort;

import com.tools.Asserts;
import com.tools.Integers;

public class MainTest {
    public static void main(String[] args) {
        Integer[] array = Integers.random(10000, 0, 10000);
        tetsSort(array,
                new BubbleSort1<Integer>()
//                new BubbleSort2<Integer>(),
//                new BubbleSort3<Integer>(),
//                new SelectionSort<Integer>(),
//                new HeapSort<Integer>()
        );

    }

    public static void tetsSort(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray) || Integers.isDescOrder(newArray));
        }

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}

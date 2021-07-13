package com.cq.source.sort;

public class InsertionSort1<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        // 插入排序优化
        for (int begin = 1; begin < array.length; begin++) {
            int oldbegin = begin;
            T cur = array[oldbegin];
            while (oldbegin > 0 && cmp(oldbegin, oldbegin - 1) < 0) {
                array[oldbegin] = array[oldbegin - 1];
                oldbegin--;
            }
            array[oldbegin] = cur;

        }
    }
}

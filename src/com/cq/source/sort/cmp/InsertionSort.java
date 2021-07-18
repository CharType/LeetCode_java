package com.cq.source.sort.cmp;

import com.cq.source.sort.Sort;

public class InsertionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        // 插入排序实现
        for (int begin = 1; begin < array.length; begin++) {
            int oldbegin = begin;
            while (oldbegin > 0 && cmp(oldbegin, oldbegin - 1) < 0) {
                swap(oldbegin, oldbegin - 1);
                oldbegin--;
            }
        }
    }
}

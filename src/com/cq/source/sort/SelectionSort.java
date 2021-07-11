package com.cq.source.sort;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        // 选择排序实现
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(maxIndex, begin) < 0) {
                    maxIndex = begin;
                }
            }
            swap(maxIndex, end);
        }
    }
}

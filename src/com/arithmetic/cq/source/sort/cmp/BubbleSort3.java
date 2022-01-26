package com.arithmetic.cq.source.sort.cmp;

import com.arithmetic.cq.source.sort.Sort;

public class BubbleSort3<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        // 冒泡排序实现
        for (int end = array.length - 1; end > 0; end--) {
            int startIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    startIndex = begin;
                }
            }
            end = startIndex;
        }
    }
}

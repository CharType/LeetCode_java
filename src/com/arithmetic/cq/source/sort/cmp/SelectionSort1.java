package com.arithmetic.cq.source.sort.cmp;

import com.arithmetic.cq.source.sort.Sort;

public class SelectionSort1<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        // 选择排序实现
//        for (int begin = 0; begin < array.length - 1; begin++) {
//            int selectIndex = begin;
//            for (int end = array.length - 1; end > begin; end--) {
//                if (cmp(begin, selectIndex) < 0) {
//                    selectIndex = begin;
//                }
//            }
//            swap(selectIndex, begin);
//        }

        for (int end = array.length - 1; end > 0; end--) {
            int selectIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, selectIndex) < 0) {
                    selectIndex = begin;
                }
            }
            swap(selectIndex, end);
        }
    }
}

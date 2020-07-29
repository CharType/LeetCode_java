package com.sort;

public class BubbleSort2<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        // 冒泡排序实现
        for (int end = array.length - 1;end > 0;end--) {
            boolean isSort = true;
            for (int begin = 1;begin <= end;begin++) {
                if (cmp(begin,begin-1) < 0) {
                    swap(begin,begin-1);
                    isSort = false;
                }
            }
            if (isSort) break;
        }
    }
}

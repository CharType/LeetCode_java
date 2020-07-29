package com.sort;

public class InsertionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        // 插入排序实现
        for (int begin = 0;begin < array.length-1;begin++) {
            
        }
        for (int end = array.length - 1;end > 0;end--) {
            for (int begin = 1;begin <= end;begin++) {
                if (cmp(begin,begin-1) < 0) {
                    swap(begin,begin-1);
                }
            }
        }
    }
}

package com.cq.source.sort;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    protected void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        int pivot = pivotIndex(begin, end);
        sort(begin, pivot);
        sort(pivot + 1, end);
    }

    private int pivotIndex(int begin, int end) {
        T v = array[begin];
        end--;
        while (begin < end) {

            while (begin < end) {
                if (cmp(v, array[end]) < 0) {
                    // 右边元素 > 轴点元素
                    // 元素本来就在右边，直接end--
                    end--;
                } else {
                    // 将右边元素覆盖到左边
                    array[begin++] = array[end];
                    break;
                }
            }

            while (begin < end) {
                if (cmp(v, array[begin]) > 0) {
                    // 左边元素小于轴点元素
                    begin++;
                } else {
                    // 左边元素大于轴点元素，将左边元素覆盖到右边
                    array[end--] = array[begin];
                    break;
                }
            }
        }

        array[begin] = v;
        return begin;
    }
}

package com.arithmetic.cq.source.sort.cmp;

public class BinarySearch {
    // 练习二分搜索
    public static int search(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (end + begin) >> 1;
            if (array[mid] > v) {
                end = mid;
            } else if (array[mid] < v) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

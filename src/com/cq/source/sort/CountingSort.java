package com.cq.source.sort;

// 计数排序实现
public class CountingSort extends Sort<Integer> {

    @Override
    protected void sort() {
        // 找出最大值
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] couts = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            couts[i]++;
        }

        int index = 0;
        for (int i = 0; i < couts.length; i++) {
            while (couts[i] > 0) {
                array[index] = i;
                index++;
                couts[i]--;
            }
        }
    }
}

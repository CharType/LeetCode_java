package com.arithmetic.cq.source.sort;

// 计数排序实现
public class CountingSort1 extends Sort<Integer> {

    @Override
    protected void sort() {
        // 找出最大值和最小值
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }


        // 统计次数
        int[] couts = new int[(max - min) + 1];
        for (int i = 0; i < array.length; i++) {
            couts[array[i] - min]++;
        }

        // 累加每个数出现的次数
        for (int i = 1; i < couts.length; i++) {
            couts[i] += couts[i - 1];
        }


        // 从后往前遍历元素，将这个元素放到数组中台合适的位置
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[--couts[array[i] - min]] = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }
}

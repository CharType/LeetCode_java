package com.arithmetic.cq.source.greedy;

import java.util.Arrays;

/**
 * 最优装载问题
 * 装多的古董
 */
public class Pirate {
    public static void main(String[] args) {
        // 总的重量30
        int w = 30;
        // 每件古董的重量
        int[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
        int count = 0, weight = 0;
        Arrays.sort(weights);
        for (int i = 0; i < weights.length; i++) {
            if (weight < w && weights[i] < w - weight) {
                count++;
                weight += weights[i];
            }
        }
        System.out.printf("最多能装" + count + "件古董");
    }
}

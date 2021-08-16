package com.cq.source.greedy;

import java.util.Arrays;

/**
 * 零钱兑换
 */

public class CoinChange {
    public static void main(String[] args) {
        Integer[] faces = {25, 10, 5, 1};
        Arrays.sort(faces);
        int coins = 0, monet = 41;
        int index = faces.length - 1;
        while (index >= 0) {
            while (faces[index] <= monet) {
                monet -= faces[index];
                coins++;
            }
            index--;
        }

        System.out.printf("一共需要" + coins + "个硬币");
    }
}

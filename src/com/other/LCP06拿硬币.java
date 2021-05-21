package com.other;

/**
 *https://leetcode-cn.com/problems/na-ying-bi/submissions/
 */
public class LCP06拿硬币 {

    public int minCount(int[] coins) {
        if (coins == null || coins.length == 0) return 0;
        int count = 0;
        for (int i = 0;i < coins.length;i++) {
            int num = coins[i];
            if (num < 2) {
                count += 1;
            } else {
                count += num / 2;
                count += num % 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LCP06拿硬币 o = new LCP06拿硬币();
//        int [] coins = {4,2,1};
        int [] coins = {2,3,10};
        System.out.println(o.minCount(coins));
    }
}

package com.arithmetic.other;

/**
 * https://leetcode-cn.com/problems/super-egg-drop/
 */
public class _887_鸡蛋掉落 {
    /**
     *
     * @param K 剩余鸡蛋数
     * @param N 是楼层
     * @return
     */
    public int superEggDrop(int K, int N) {
        if (N == 0 ) return 0;
        if (N == 1) return N;
        int [][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int j =1;j <=K ; j++) {
                dp[j][m] = dp[j][m-1] + dp[j-1][m-1]+1;
            }
        }

        return m;
    }

    public static void main(String[] args) {
        _887_鸡蛋掉落 o = new _887_鸡蛋掉落();
        System.out.print(o.superEggDrop(2,6));
    }
}

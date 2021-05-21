package com.探索.腾讯.附加;

/**
 *https://leetcode-cn.com/explore/interview/card/tencent/228/bonus/943/
 */
public class Nim游戏 {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        Nim游戏 o = new Nim游戏();
        System.out.println(o.canWinNim(16));
    }
}

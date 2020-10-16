package com.精选Top面试题.中等;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class _29_两数相除 {
    /**
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return
     */
    public int divide(int dividend, int divisor) {
        // 如果除数为1 直接返回被除数
        if(divisor == 1) return dividend;
        // 边界检查
        if(divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        long a = dividend;
        long b = divisor;

        long ans;
        if(a > 0 && b > 0) {
            ans = div(a,b);
        } else if(a <0 && b < 0) {
            ans = div(-a, -b);
        } else {
            ans = -div(Math.abs(a), Math.abs(b));
        }


        return (int) ans;
    }

    public long div(long a, long b) {

        // 被除数比除数小，直接而返回0
        if(a < b) return 0;

        int i = 0;
        // 求出多少个i相乘 小于a 位运算能直接计算出倍数
        while( a >= (b<<i) ){
            i++;
        }
        // 已经大于了 要在减一次
        i--;
        // 计算剩余数字
        return (1<<i) + div(a - (b<<i) , b);
    }


    public static void main(String[] args) {
        _29_两数相除 o = new _29_两数相除();
        System.out.print(10<<1);
        System.out.println("");
        System.out.print(1<<6);
        System.out.println("");
        System.out.print(o.divide(1000,10));
    }
}

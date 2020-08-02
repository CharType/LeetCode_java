package com.other;

/**
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 */
public class _1486_数组异或操作 {
    public int xorOperation(int n, int start) {
        int sum = 0;
        for (int i = 0;i < n;i++) {
           sum ^= (start + 2 * i);
        }
        return sum;
    }
    public static void main(String[] args) {
        _1486_数组异或操作 o = new _1486_数组异或操作();
        System.out.println(o.xorOperation(5,0));
    }
}

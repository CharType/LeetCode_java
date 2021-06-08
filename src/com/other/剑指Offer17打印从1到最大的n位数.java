package com.other;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class 剑指Offer17打印从1到最大的n位数 {

    public int[] printNumbers(int n) {
        int num = 1;
        while (n > 0) {
            num = num * 10;
            n--;
        }
        int[] result = new int[num - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        剑指Offer17打印从1到最大的n位数 o = new 剑指Offer17打印从1到最大的n位数();
        Integers.println(o.printNumbers(1));
        Integers.println(o.printNumbers(2));
        
    }
}

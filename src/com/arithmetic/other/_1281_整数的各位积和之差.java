package com.arithmetic.other;

/**
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class _1281_整数的各位积和之差 {

    public int subtractProductAndSum(int n) {
        if (n <= 1) return 0;
        int sum = 0;
        int ans = 1;
        while (n > 0) {
            int num = n % 10;
            sum += num;
            ans *= num;
            n = n / 10;
        }
        return ans - sum;
    }

    public static void main(String[] args) {
        _1281_整数的各位积和之差 o = new _1281_整数的各位积和之差();
//        System.out.println(o.subtractProductAndSum(345));
        System.out.println(o.subtractProductAndSum(114));
    }


}

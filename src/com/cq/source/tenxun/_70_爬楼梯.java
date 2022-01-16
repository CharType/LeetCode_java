package com.cq.source.tenxun;

public class _70_爬楼梯 {

    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = second + first;
            first = second - first;
        }
        return second;
    }

    public static void main(String[] args) {
        _70_爬楼梯 o = new _70_爬楼梯();
        System.out.println(o.climbStairs(64));

    }
}

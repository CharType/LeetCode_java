package com.arithmetic.精选Top面试题.简单;

/**
 *
 */
public class _x_的平方根 {
    public int mySqrt(int x) {
        if (x < 1) return 0;
        if (x == 1) return 1;
        int left = 1;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if ((long)middle * middle <= x) {
                ans = middle;
                left = middle + 1;

            } else {
                right = middle - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _x_的平方根 o = new _x_的平方根();
        System.out.println(o.mySqrt(2147395599));

    }
}

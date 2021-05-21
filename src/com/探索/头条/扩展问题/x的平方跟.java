package com.探索.头条.扩展问题;


/**
 *题解：
 * 二分查找
 * 注意int * int 会溢出的问题 需要先转换成long类型
 */
public class x的平方跟 {
    public int mySqrt(int x) {
        if (x < 1) return 0;
        if (x == 1) return 1;
        int left = 1;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if ((long)middle * middle <= x) {
                ans = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return ans;
//        return (int)Math.sqrt(x);
    }

    public static void main(String[] args) {
        x的平方跟 o = new x的平方跟();
        System.out.println(o.mySqrt(2147395599));
    }
}

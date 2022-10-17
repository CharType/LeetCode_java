package com.arithmetic.腾讯精选练习;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例1:
 *
 * 输入: 123
 * 输出: 321
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 来源：力扣（leetcode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _7_整数反转 {
    public int reverse(int x) {
        long res = 0;
        while ( x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        _7_整数反转 o = new _7_整数反转();
        System.out.println(o.reverse(2100));
    }
}

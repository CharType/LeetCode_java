package com.arithmetic.精选Top面试题.简单;

/**
 * 示例 1：
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 *
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _190_颠倒二进制位 {
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public int reverseBits1(int n) {
        int ans = 0;
        for (int i = 1;i<=31;i++) {
            ans = ans+((1&(n>>i)) << (31 - i));
        }
        return ans;
    }

    public static void main(String[] args) {
        _190_颠倒二进制位 o = new _190_颠倒二进制位();
//        System.out.println(o.reverseBits(3221225471));
        System.out.println(o.reverseBits1(43261596));
    }
}

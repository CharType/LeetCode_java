package com.精选Top面试题.简单;

/**
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _371_两整数之和 {
    //TODO:使用位运算来看
    public int getSum(int a, int b) {
        int res = a ^ b;
        return res;
    }

    public static void main(String[] args) {
        _371_两整数之和 o = new _371_两整数之和();
        System.out.println(o.getSum(2,3));
    }
}

package com.精选Top面试题;

/**
 * 罗马数字转换成整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 * 整数转换成罗马数字
 * https://leetcode-cn.com/problems/integer-to-roman/
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _12_13_罗马数字和整数互转 {

    // TODO:整数转换成罗马数字
    public String intToRoman(int num) {
        return "";
    }
    // 罗马数字转换成整数
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int value = 0;
        char [] chars = s.toCharArray();
        for (int i = 0; i <chars.length; i++) {
            char c = chars[i];
            switch (c) {
                case 'I':
                    if (i+1 >= chars.length) {
                        value = value + 1;
                    } else {
                        switch (chars[i+1]) {
                            case 'V':
                                value = value + 4;
                                i++;
                                break;
                            case 'X':
                                value = value + 9;
                                i++;
                                break;
                            default:
                                value = value + 1;
                                break;
                        }
                    }
                    break;
                case 'X':
                    if (i+1 >= chars.length) {
                        value = value + 10;
                    } else {
                        switch (chars[i+1]) {
                            case 'L':
                                value = value + 40;
                                i++;
                                break;
                            case 'C':
                                value = value + 90;
                                i++;
                                break;
                            default:
                                value = value + 10;
                                break;
                        }
                    }
                    break;

                case 'C':
                    if (i+1 >= chars.length) {
                        value = value + 100;
                    } else {
                        switch (chars[i+1]) {
                            case 'D':
                                value = value + 400;
                                i++;
                                break;
                            case 'M':
                                value = value + 900;
                                i++;
                                break;
                            default:
                                value = value + 100;
                                break;
                        }
                    }
                    break;
                case 'V':
                    // 当前数字等于5的时候直接赋值
                    value = value + 5;
                    break;
                case 'L':
                    // 当前数字等于50的时候直接赋值
                    value = value + 50;
                    break;
                case 'D':
                    // 当前数字等于50的时候直接赋值
                    value = value + 500;
                    break;
                case 'M':
                    // 当前数字等于1000的时候直接赋值
                    value = value + 1000;
                    break;
            }

        }
        return value;
    }

    public static void main(String[] args) {
        _12_13_罗马数字和整数互转 o = new _12_13_罗马数字和整数互转();
        System.out.println(o.romanToInt("III"));
    }
}

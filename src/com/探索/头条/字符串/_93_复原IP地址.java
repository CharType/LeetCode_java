package com.探索.头条.字符串;

import com.tools.Times;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class _93_复原IP地址 {

    //DFS
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s,0,"",res);
        return res;
    }

    /**
     *
     * @param s 字符串
     * @param i 第几部了
     * @param out 最后输出的字符串
     * @param res 集合
     */
    private void helper(String s, int i, String out, List<String> res) {
        if (i == 4) {
            if (s.isEmpty()) {
                res.add(out);
            }
            return;
        }
        // 遍历 从1到4 正好3位
        for (int k = 1;k < 4;++k) {
            // 如果最后的位数 < k的时候不需要在继续深度遍历了，没有必要
            if (s.length() < k) break;
            // 截取0到k的字符串转换为数字
            int val = Integer.parseInt(s.substring(0,k));
            // 如果数字大于255 或者 K 和数字的位数不相等 直接跳过
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper(s.substring(k),i + 1,out + s.substring(0,k) + (i == 3 ? "" : "."), res);
        }
    }


    // 暴力法
    public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<String>();
        for (int a = 1; a < 4; ++a)
            for (int b = 1; b < 4; ++b)
                for (int c = 1; c < 4; ++c)
                    for (int d = 1; d < 4; ++d)
                        if (a + b + c + d == s.length()) {
                            int A = Integer.parseInt(s.substring(0, a));
                            int B = Integer.parseInt(s.substring(a, a + b));
                            int C = Integer.parseInt(s.substring(a + b, a + b + c));
                            int D = Integer.parseInt(s.substring(a + b + c));
                            if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                                String t = String.valueOf(A) + "." + String.valueOf(B) + "." + String.valueOf(C) + "." + String.valueOf(D);
                                if (t.length() == s.length() + 3) res.add(t);
                            }
                        }
        return res;
    }


    //最优解
    private List<String> result = new ArrayList<>();
    private char[] tmp;
    public List<String> restoreIpAddresses2(String s) {
        tmp = new char[s.length() + 3];
        backtrace(s, 0, 0);
        return result;
    }

    private void backtrace(String s, int start, int step) {
        int n = s.length();
        if (n - start < 4 - step || n - start > (4 - step) * 3) return;
        if (step == 4) {
            result.add(new String(tmp));
            return;
        }
        if (step > 0) tmp[start + step - 1] = '.';
        tmp[start + step] = s.charAt(start);
        backtrace(s, start + 1, step + 1);
        if (s.charAt(start) == '0' || start >= n - 1) return;
        tmp[start + step + 1] = s.charAt(start + 1);
        backtrace(s, start + 2, step + 1);
        if (start + 2 >= n) return;
        tmp[start + step + 2] = s.charAt(start + 2);
        if ((s.charAt(start) - '0') * 100 + (s.charAt(start + 1) - '0') * 10 + s.charAt(start + 2) - '0' <= 255) {
            backtrace(s, start + 3, step + 1);
        }
    }

    public static void main(String[] args) {
        _93_复原IP地址 o = new _93_复原IP地址();
        String s1 = "25525511135";
//        Times.test("DFS", new Times.Task() {
//            @Override
//            public void execute() {
//                System.out.println(o.restoreIpAddresses(s1));
//            }
//        });

//        Times.test("暴力法", new Times.Task() {
//            @Override
//            public void execute() {
//                System.out.println(o.restoreIpAddresses1(s1));
//            }
//        });
//
        Times.test("别人写的最优解", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(o.restoreIpAddresses2(s1));
            }
        });

    }
}

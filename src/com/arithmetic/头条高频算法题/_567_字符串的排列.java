package com.arithmetic.头条高频算法题;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class _567_字符串的排列 {

    /**
     * 使用数组方式来解决，中间部分没有太理解为什么要这样做
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        // 如果有一个字符串为null  直接返回false
        if (s1 == null || s2 == null) return false;
        char [] s1Chars = s1.toCharArray();
        char [] s2Chars = s2.toCharArray();
        // 如果s1的长度大于s2的长度，肯定不包括它的全排列，直接返回false
        if (s1Chars.length > s2Chars.length) {
            return false;
        }
        // 声明一个长度为26的数组
        int [] s1map = new int[26];
        // 先记录s1中每个字符出现的次数
        for (int i = 0;i<s1Chars.length;i++) {
            s1map[s1Chars[i] - 'a']++;
        }
        // 外层遍历s2到s1的差值
        for (int i = 0;i<s2Chars.length - s1Chars.length;i++) {
            // 重新声明一个数组用来存储
            int [] s2map = new int[26];
            for (int j = 0;j < s1Chars.length;j++) {
                s2map[s2Chars[i + j] - 'a']++;
            }
            if (matches(s1map,s2map)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] slmap, int[] s2map) {
        for (int i = 0;i < 26;i++) {
            if (slmap[i] != s2map[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计字符出现的次数
     * @param s1
     * @param s2
     * 一、分析
     * 1.判断是否包含 s1 的排列的方法：
     * 截取 s2 中某长度和 s1 字符串长度相等的子串，判断两者每个字符的数量是否一致即可。
     * 2.统计字符数量
     * 由于字符串只包含 26 个小写字母，我们可以使用 计数排序 来统计，即创建一个长度为 26 的数组，其下标 0 ~ 25 对应 a ~ z 的每个字母，其值为对应字母出现的次数。
     * 3.判断条件
     * 先统计 s1 的字符数量 count1，再依次统计 s2 中与之长度相等的子串的字符数量 count2，比较两者是否相同。
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        // 如果有一个字符串为null  直接返回false
        if (s1 == null || s2 == null) return false;
        char [] s1Chars = s1.toCharArray();
        char [] s2Chars = s2.toCharArray();
        // 如果s1的长度大于s2的长度，肯定不包括它的全排列，直接返回false
        if (s1Chars.length > s2Chars.length) {
            return false;
        }
        // 声明两个个长度为26的数组
        int [] s1map = new int[26];
        int [] s2map = new int[26];
        // 统计字符串s1中字符出现的次数，统计相同长度的s2字符串中字符出现的次数
        for (int i = 0;i < s1Chars.length;i++) {
            s1map[s1Chars[i] - 'a']++;
            s2map[s2Chars[i] - 'a']++;
        }
        // 滑动窗口，滑动长度始终为s1.length
        for (int i = s1Chars.length;i < s2Chars.length;i++) {
            if (isSame(s1map,s2map)) {
                return true;
            }
            // 去掉滑块当前的首个字符
            s2map[s2Chars[i - s1Chars.length] - 'a']--;
            // 将当前的字符添加到滑块中去
            s2map[s2Chars[i] - 'a']++;
        }

        return isSame(s1map,s2map);
    }

    private boolean isSame(int[] s1map, int[] s2map) {
        for (int i = 0;i < s1map.length;i++) {
            if (s1map[i] != s2map[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _567_字符串的排列 o = new _567_字符串的排列();
        // 测试用例1 通过
        String s1 = "ab";
        String s2 = "eiadbaooo";
        // 测试用例2
//        String s1 = "ab";
//        String s2 = "eidboaoo";
        System.out.println(o.checkInclusion2(s1,s2));

    }
}

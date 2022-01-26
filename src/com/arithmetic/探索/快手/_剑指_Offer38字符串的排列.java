package com.arithmetic.探索.快手;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class _剑指_Offer38字符串的排列 {

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        char [] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        List<Character>  list1 = new ArrayList<>();
        dfs(chars,0,list1,list);
        System.out.println(list);
        return null;
    }

    public void dfs(char [] chars, int dept, List<Character> chars1, List<String> list) {
        if (dept == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < chars1.size();i++) {
                sb.append(chars1.get(i));
            }
            list.add(sb.toString());
            return;
        }

        for (int i = 0;i< chars.length;i++) {
            if (!chars1.contains(chars[i])) {
                chars1.add(chars[i]);
                dfs(chars,dept+1,chars1,list);
                chars1.remove(chars1.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        _剑指_Offer38字符串的排列 o = new _剑指_Offer38字符串的排列();
        System.out.println(o.permutation("abc"));
    }
}

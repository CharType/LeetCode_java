package com.arithmetic.精选Top面试题.中等;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class _131_分割回文串 {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String >> res = new ArrayList<>();
        if (len == 0) return res;
        // dp[i][j] 表示s[i][j]是否是回文串
        boolean [][] dp = new boolean[len][len];
        for (int j = 0; j < len ; j++) {
            for (int i = 0;i <= j;i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s,0,len,dp,stack,res);
        return res;

    }
    private void backtracking(String s, int start, int len,boolean [][] dp,Deque<String> path,List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start;i < len;i++) {
            if (!dp[start][i]) continue;
            path.addLast(s.substring(start,i+1));
            backtracking(s,i+1,len,dp,path,res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        _131_分割回文串 o = new _131_分割回文串();
        System.out.println(o.partition("aab"));
    }
}

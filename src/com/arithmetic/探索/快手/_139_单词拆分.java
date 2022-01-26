package com.arithmetic.探索.快手;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-break/
 */
public class _139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        Set<String> set = new HashSet<>(wordDict.size());
        for (int i = 0;i < wordDict.size();i++) {
            set.add(wordDict.get(i));
        }
        for (int i = 0;i < s.length();i++) {

        }
        return false;
    }

    public static void main(String[] args) {

    }
}

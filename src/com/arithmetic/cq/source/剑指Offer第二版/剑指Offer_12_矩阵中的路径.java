package com.arithmetic.cq.source.剑指Offer第二版;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [
 * ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]],
 * word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 */
public class 剑指Offer_12_矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        char[] words = word.toCharArray();
        for (int w = 0; w < words.length; w++) {
            for (int i = 0; i < board.length; i++) {
                char[] chars = board[i];
                for (int j = 0; j < chars.length; j++) {
                    if (words[w] == board[i][j]) {
                        // 找到第一个字符
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}

package com.arithmetic.探索.腾讯.数组和字符串;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/906/
 */
public class 反转字符串中的单词III {

    public String reverseWords(String s) {
        if (s == null) return null;
        char [] chars = s.toCharArray();
        if (chars.length == 0) return "";


        // 记录一共有多少个有效的元素
        int len = 0;
        // 当前字符插入的位置
        int cur = 0;
        // 记录前一个字符是否是空格
        boolean spec = false;
        for (int i = 0;i < chars.length;i++) {
            if (chars[i] != ' ') {
                spec = false;
                chars[cur++] = chars[i];
            } else if (spec == false){
                chars[cur++] = chars[i];
                spec = true;
            }
        }

        len = spec ? (cur - 1) : cur;
        int prevIndex = -1;
        for (int i = 0;i < len;i++) {
            if (chars[i] != ' ') continue;
            reversWord(chars,prevIndex + 1,i);
            prevIndex = i;
        }
        reversWord(chars,prevIndex + 1,len);
        return new String(chars,0,len);
    }

    public void reversWord(char [] chars,int left,int right) {
        right--;
        // 先字符串反转
        while (left < right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        反转字符串中的单词III o = new 反转字符串中的单词III();
        System.out.println(o.reverseWords("Let's take LeetCode contest"));
    }
}

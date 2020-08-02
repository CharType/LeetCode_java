package com.other;

/**
 *https://leetcode-cn.com/problems/guess-numbers/
 */
public class _LCP01猜数字 {
    public int game(int[] guess, int[] answer) {
        if (guess == null || answer == null) return 0;
        int count = 0;
        for (int i = 0;i < guess.length;i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        _LCP01猜数字 o = new _LCP01猜数字();
        int [] nums = {1,2,3};
        int [] num2 = {1,2,3};
        System.out.println(o.game(nums,num2));
    }
}

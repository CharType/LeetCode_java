package com.arithmetic.探索.头条.数组;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class 剑指Offer45_把数组排成最小的数 {

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] >= 10) {
                int num = nums[i];
                while (num >= 10) {
                    int n = num % 10;
                    queue.add(n);
                    num = num / 10;
                }
                queue.add(num % 10);
            } else {
                queue.add(nums[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        boolean isAdd = false;
        while (!queue.isEmpty()) {
            Integer num =  queue.remove();
            if (num > 0 && !isAdd) {
                list.add(0,num);
                isAdd = true;
            } else  {
                list.add(num);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < list.size();i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        剑指Offer45_把数组排成最小的数 o = new 剑指Offer45_把数组排成最小的数();
//        int [] nums = {10,2};
//        int [] nums = {3,30,34,5,9};
        int [] nums = {2048};
        System.out.println(o.minNumber(nums));
    }
}

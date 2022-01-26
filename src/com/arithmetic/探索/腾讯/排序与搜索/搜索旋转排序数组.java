package com.arithmetic.探索.腾讯.排序与搜索;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/224/sort-and-search/927/
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int li = 0,ri = n - 1;
        while (li <= ri) {
            int mid = (ri + li) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                // 看数据是否在左半部分
                if (nums[0] <= target && target < nums[mid]) {
                    ri = mid - 1;
                } else {
                    li = mid + 1;
                }
            } else {
                // 数据是否在右班部分
                if (nums[mid] < target && target <= nums[n - 1]) {
                    li = mid + 1;
                } else {
                    ri = mid - 1;
                }
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        搜索旋转排序数组 o =  new 搜索旋转排序数组();
        int [] nums = {4,5,6,7,0,1,2};
        System.out.println(o.search(nums,6));
    }
}

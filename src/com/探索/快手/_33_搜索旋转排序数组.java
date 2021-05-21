package com.探索.快手;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class _33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] ==  target) return mid;
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    // 在前半部分
                    r = mid-1;
                } else {
                   // 在后半部分
                    l = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[n-1]) {
                    // 在后半部分
                    l = mid+1;
                } else {
                    // 在前半部分
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _33_搜索旋转排序数组 o = new _33_搜索旋转排序数组();
        int [] nums = {4,5,6,7,0,1,2};
        System.out.print(o.search(nums,0));
    }
}

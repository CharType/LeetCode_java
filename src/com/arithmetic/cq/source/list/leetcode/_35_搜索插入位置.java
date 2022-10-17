package com.arithmetic.cq.source.list.leetcode;

public class _35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _35_搜索插入位置 o = new _35_搜索插入位置();
        int[] nums = {1, 3, 5, 6};
        System.out.println(o.searchInsert(nums, 2));
    }
}

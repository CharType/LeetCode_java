package com.arithmetic.cq.source.tenxun;

public class _33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        if (n == 1 && nums[0] == target) return 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _33_搜索旋转排序数组 o = new _33_搜索旋转排序数组();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(o.search1(nums, 0));
    }
}

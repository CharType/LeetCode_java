package com.cq.source.tenxun;

public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int li = 0, ri = height.length - 1;
        int res = 0;
        while (li < ri) {
            int len = ri - li;
            res = Math.max(res, Math.min(height[li], height[ri]) * len);
            if (height[li] > height[ri]) {
                ri--;
            } else {
                li++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _11_盛最多水的容器 o = new _11_盛最多水的容器();
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(o.maxArea(nums));
    }
}

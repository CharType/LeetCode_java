package com.精选Top面试题.简单;

import java.util.Arrays;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _268_缺失数字 {
    //TODO:暂时先放一下，没做完
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int resurt = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != (nums[0]+i)) {
                resurt = nums[i -1]+1;
                break;
            }
        }
        if (resurt == 0) {
            resurt = nums[nums.length - 1] + 1;
        }
        return resurt;
    }

    public static void main(String[] args) {
        _268_缺失数字 o = new _268_缺失数字();
//        int [] nums = {9,6,4,2,3,5,7,0,1};
        int [] nums = {0,1};
        System.out.println(o.missingNumber(nums));
    }
}

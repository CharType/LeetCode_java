package com.arithmetic.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class _1431_拥有最多糖果的孩子 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null) return new ArrayList<Boolean>();
        int maxValue = 0;
        for (int i = 0;i < candies.length; i++) {
            maxValue = Math.max(maxValue, candies[i]);
        }
        List<Boolean> list = new ArrayList<>(candies.length);
        for (int i = 0; i< candies.length;i++) {
            if ((candies[i] + extraCandies) >= maxValue) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        _1431_拥有最多糖果的孩子 o = new _1431_拥有最多糖果的孩子();
        int [] candies = {2,3,5,1,3};
        System.out.println(o.kidsWithCandies(candies, 3));
    }
}

package com.arithmetic.头条高频算法题;

import com.arithmetic.tools.Integers;

/**
 * https://leetcode-cn.com/problems/candy/
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _135_分发糖果 {
    public int candy(int[] ratings) {
        int count = 0;
        if (ratings == null) return count;
        if (ratings.length == 1) return 1;
        int [] counts = new int[ratings.length];
        for (int i = 0;i < ratings.length;i++) {
            // 第一个和最后一个单独处理
            if (i == 0) {
                if (ratings[i] > ratings[i+1]) {
                    counts[i] = 2;
                    count += 2;
                } else {
                    counts[i] = 1;
                    count += 1;
                }
            } else if (i == ratings.length - 1) {
                if ((ratings[i]) > (ratings[i-1])) {
                    counts[i] = 2;
                    count += 2;
                } else {
                    counts[i] = 1;
                    count += 1;
                }
            } else {
                if (ratings[i] > ratings[i-1]) {
                    counts[i] = counts[i - 1] + 1;
                    count += counts[i];
                } else {
                    counts[i] = 1;
                    count += 1;
                }
            }
        }

        for (int i = ratings.length - 2;i > 0;i--) {

            if (ratings[i] > ratings[i-1] && counts[i] < counts[i-1]) {
                counts[i] = counts[i - 1] + 1;
                count += counts[i];
            }
        }
        Integers.println(counts);
        return count;
    }

    public static void main(String[] args) {
        _135_分发糖果 o = new _135_分发糖果();
        int [] ratings = {1,0,2,6,5,8,2,1,9,4};
        System.out.printf(Integer.toString(o.candy(ratings)));
        System.out.printf("\n");
        Integers.println(ratings);
    }
}

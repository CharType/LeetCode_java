package com.arithmetic.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 */
public class _120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle ==  null || triangle.size() == 0) return 0;
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();
        int [][] dp = new int[m][n];
        for (int i = 0;i < n;i++) {
            List<Integer> list = triangle.get(triangle.size()-1);
            dp[m-1][i] = list.get(i);
        }
        for (int i = m-2;i >= 0;i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0;j<list.size();j++) {
                dp[i][j] = list.get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)  return 0;
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();
        int [][]dp = new int[m][n];
        List<Integer> list = triangle.get(triangle.size()-1);
        for(int i = 0;i < n;i++) {
            dp[m-1][i] = list.get(i);
        }
        for(int i = m-2 ;i >=0 ;i--) {
            List<Integer> tempList = triangle.get(i);
            for(int j = 0;j <tempList.size();j++){
                dp[i][j] =  Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        _120_三角形最小路径和 o = new _120_三角形最小路径和();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(1);
        List<Integer> list2 = new ArrayList<>(2);
        List<Integer> list3 = new ArrayList<>(3);
        List<Integer> list4 = new ArrayList<>(4);
        list1.add(2);

        list2.add(3);
        list2.add(4);

        list3.add(5);
        list3.add(6);
        list3.add(7);

        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        System.out.println(o.minimumTotal2(list));
    }
}

package com.other;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class _771_宝石与石头 {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) return 0;
        char [] jchars = J.toCharArray();
        char [] schars = S.toCharArray();
        if (jchars.length == 0 || schars.length == 0) return 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0;i < jchars.length;i++) {
            set.add(jchars[i]);
        }
        int count = 0;
        for (int i = 0;i < schars.length;i++) {
            if (set.contains(schars[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _771_宝石与石头 o = new _771_宝石与石头();
        System.out.println(o.numJewelsInStones("aA","aAAbbbb"));
    }
}

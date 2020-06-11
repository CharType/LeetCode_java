package com.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 */
public class _990_等式方程的可满足性 {

    public boolean equationsPossible(String[] equations) {
        if (equations == null) return false;
        Map<Character,Character> equats = new HashMap<>();
        Map<Character,Character> noEquats = new HashMap<>();


        for (int i = 0;i<equations.length;i++){
            String str = equations[i];
            char [] chars = str.toCharArray();
            char oneNumber = chars[0];
            char twoNumber = chars[3];
            char eq = chars[1];
            if (eq == '=') {
                if (!noEquats.containsKey(oneNumber) && !equats.containsKey(oneNumber)) {
                    equats.put(oneNumber,twoNumber);
                } else if (noEquats.containsKey(oneNumber) && !equats.containsKey(oneNumber)) {
                    char oneNumberValue = noEquats.get(oneNumber);
                    if (oneNumberValue ==  twoNumber) {
                        return false;
                    }
                } else if (!noEquats.containsKey(oneNumber) && equats.containsKey(oneNumber)) {
                    char oneNumberValue = noEquats.get(oneNumber);
                    equats.put(oneNumber,twoNumber);
                }
            } else if (eq == '!') {
                if (!noEquats.containsKey(oneNumber) && !equats.containsKey(oneNumber)) {
                    noEquats.put(oneNumber,twoNumber);
                } else if (!noEquats.containsKey(oneNumber) && equats.containsKey(oneNumber)) {
                    char oneNumberValue = equats.get(oneNumber);
                    if (oneNumberValue ==  twoNumber) {
                        return false;
                    }
                } else if (noEquats.containsKey(oneNumber) && !equats.containsKey(oneNumber)) {
                    equats.put(oneNumber,twoNumber);
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {

    }
}

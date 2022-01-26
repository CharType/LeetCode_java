package com.arithmetic.探索.快手;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class _17_电话号码的字母组合_2 {
    private Map<String, String> map;
    List<String> result = new ArrayList<>();
    _17_电话号码的字母组合_2(){
        this.map = new HashMap<>();
        {
            map.put("2","abc");
            map.put("3","def");
            map.put("4","ghi");
            map.put("5","jkl");
            map.put("6","mno");
            map.put("7","pqrs");
            map.put("8","tuv");
            map.put("9","wxyz");
        }
    }
    public List<String> letterCombinations(String digits) {

        if (digits == null) return result;
        if (digits.length() != 0) {
            backtrack("",digits);
        }

        return result;
    }

    public void backtrack(String combination,String next_digits) {
        if (next_digits.length() == 0) {
            result.add(combination);
        } else {
            String digit = next_digits.substring(0,1);
            String letters = map.get(digit);
            for (int i = 0;i < letters.length();i++) {
                String letter = map.get(digit).substring(i,i+1);
                backtrack(combination + letter,next_digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        _17_电话号码的字母组合_2 o = new _17_电话号码的字母组合_2();
        System.out.println(o.letterCombinations("23"));
    }
}

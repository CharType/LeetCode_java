package com.arithmetic.探索.快手;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class _17_电话号码的字母组合 {
    private Map<Integer, List<Character>> map;
    List<String> result = new ArrayList<>();
    _17_电话号码的字母组合 (){
        this.map = new HashMap<>();
        {
            List<Character> list = new ArrayList<>();
            list.add('a');
            list.add('b');
            list.add('c');
            map.put(2,list);
        }
        {
            List<Character> list = new ArrayList<>();
            list.add('d');
            list.add('e');
            list.add('f');
            map.put(3,list);
        }
        {
            List<Character> list = new ArrayList<>();
            list.add('g');
            list.add('h');
            list.add('i');
            map.put(4,list);
        }
        {
            List<Character> list = new ArrayList<>();
            list.add('j');
            list.add('k');
            list.add('l');
            map.put(5,list);
        }
        {
            List<Character> list = new ArrayList<>();
            list.add('m');
            list.add('n');
            list.add('o');
            map.put(6,list);
        }
        {
            List<Character> list = new ArrayList<>();
            list.add('p');
            list.add('q');
            list.add('r');
            list.add('s');
            map.put(7,list);
        }
        {
            List<Character> list = new ArrayList<>();
            list.add('t');
            list.add('u');
            list.add('v');
            map.put(8,list);
        }
        {
            List<Character> list = new ArrayList<>();
            list.add('w');
            list.add('x');
            list.add('y');
            list.add('z');
            map.put(9,list);
        }
    }
    public List<String> letterCombinations(String digits) {

        if (digits == null) return result;
        char [] chars = digits.toCharArray();
        if (chars.length == 0) return result;
        letterCombinations(chars,0,new ArrayList<Character>());
        return result;
    }
    public List<String> letterCombinations(char []chars,int index, ArrayList<Character> resultChars) {
        if (index == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < resultChars.size();i++) {
                sb.append(resultChars.get(i));
            }
            result.add(sb.toString());
        } else {
            for (int i = index;i < chars.length;i++) {
                List<Character> list =  map.get(Integer.parseInt(String.valueOf(chars[i])));
                for (int j = 0;j < list.size();j++) {
                    if (resultChars.contains(list.get(j))) continue;
                    resultChars.add(list.get(j));
                    letterCombinations(chars,index+1,resultChars);
                    resultChars.remove(list.get(j));
                }

            }
        }


        return result;
    }

    public static void main(String[] args) {
        _17_电话号码的字母组合 o = new _17_电话号码的字母组合();
        System.out.println(o.letterCombinations("23"));
    }
}

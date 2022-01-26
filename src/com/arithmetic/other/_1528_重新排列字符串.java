package com.arithmetic.other;

public class _1528_重新排列字符串 {
    public String restoreString(String s, int[] indices) {
        if (s == null) return null;
        char [] chars = s.toCharArray();
        if (chars.length == 0) return null;

        char [] result = new char[indices.length];
        for (int i = indices.length - 1;i>= 0;i--) {
            result[indices[i]] = chars[i];
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        _1528_重新排列字符串 o = new _1528_重新排列字符串();
        int [] indexs = {4,5,6,7,0,2,1,3};
        System.out.println(o.restoreString("codeleet",indexs));

        int [] index2 = {3,1,4,2,0};
        System.out.println(o.restoreString("aiohn",index2));


    }
}

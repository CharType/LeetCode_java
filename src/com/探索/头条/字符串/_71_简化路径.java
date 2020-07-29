package com.探索.头条.字符串;

import com.tools.Asserts;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 * 使用栈区去处理
 * 先按/ 拆分
 * 主页处理 .. 上级目录这种 如果不是空的直接pop,其他出错情况直接忽略 否则直接push
 * 处理完后栈中没有数据直接返回 /
 * 否则拼起来在返回
 */
public class _71_简化路径 {

    public String simplifyPath(String path) {
        if (path == null) return "";
        Stack<String> stack = new Stack<>();
        String [] paths = path.split("/");
        for (int i = 0;i < paths.length;i++) {
            if (!stack.isEmpty() && paths[i].equals("..")) {
                stack.pop();
            } else if(!paths[i].equals("") && !paths[i].equals(".") && !paths[i].equals("..")){
                stack.push(paths[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size();i++) {
            sb.append("/").append(stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _71_简化路径 o = new _71_简化路径();
        String s1 = "/a//b////c/d//././/..";
        String s2 = "/a/../../b/../c//.//";
        String s3 = "/a/./b/../../c/";
        String s4 = "/home//foo/";
        String s5 = "/../";
        String s6 = "/home/";
        Asserts.test(o.simplifyPath(s1).equals("/a/b/c"));
        Asserts.test(o.simplifyPath(s2).equals("/c"));
        Asserts.test(o.simplifyPath(s3).equals("/c"));
        Asserts.test(o.simplifyPath(s4).equals("/home/foo"));
        Asserts.test(o.simplifyPath(s5).equals("/"));
        Asserts.test(o.simplifyPath(s6).equals("/home"));


    }
}

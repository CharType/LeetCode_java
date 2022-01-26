package com.arithmetic.探索.快手;

/**
 *https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class _165_比较版本号 {

    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) return 0;
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        int version1index = 0;
        int version2index = 0;
        while (version1index < version1s.length && version2index < version2s.length) {
            int v1 = Integer.parseInt(version1s[version1index]);
            int v2 = Integer.parseInt(version2s[version2index]);
            if(v1 > v2) {
                return 1;
            } else if(v1 < v2) {
                return -1;
            } else {
                version1index++;
                version2index++;
            }
        }
        if (version1index < version1s.length) {
            while (version1index < version1s.length) {
                int v1 = Integer.parseInt(version1s[version1index]);
                if (v1 != 0) {
                    return 1;
                }
                version1index++;
            }
        }

        if (version2index < version2s.length) {
            while (version2index < version2s.length) {
                int v2 = Integer.parseInt(version2s[version2index]);
                if (v2 != 0) {
                return -1;
                }
                version2index++;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        _165_比较版本号 o = new _165_比较版本号();
//        System.out.println(o.compareVersion("01","1"));
//        System.out.println(o.compareVersion("0.1","1.1"));
//        System.out.println(o.compareVersion("1.1","1.1"));
//        System.out.println(o.compareVersion("1.345.678.987","1.345.678.978"));
//        System.out.println(o.compareVersion("1","1.0"));
        System.out.println(o.compareVersion("1.1","1.01.0"));

//        String str = "123.456.789";
//        String [] strs = str.split("\\.");
//        System.out.println(strs);

    }
}

import com.arithmetic.tools.Asserts;

/**
 * https://leetcode-cn.com/leetbook/read/tencent/xxzqki/
 * 1.先找到最端的字符串长度
 *  * 2.定义2个指针 从最左和最右往中间进行而二分查找
 *  * (hig - low + 1) / 2 + low;
 *  * 每次计算当前的串数组中是不是公共的前缀，不是leef
 */
public class 最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        // 先找到最短的那个值
        int minLength = Integer.MAX_VALUE;
        for (String str:strs) {
            minLength = Math.min(minLength, str.length());
        }
        // 使用二分查找
        int li = 0,len = minLength;
        while (li < len) {
            int mid = (len - li + 1 ) / 2 + li;
            if (isCommonPrefix(strs,mid)) {
                li = mid;
            } else {
                len = mid - 1;
            }
        }

        return strs[0].substring(0,len);
    }

    /**
     * 判断字符串数组中从0到length的长度字符串是否相等
     * @param strs
     * @param length
     * @return
     */
    public  boolean isCommonPrefix(String [] strs,int length) {
        String str0 = strs[0].substring(0,length);
        for (int i = 0;i < strs.length;i++) {
            String str = strs[i];
            for (int j = 0;j < length;j++) {
                if(str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        最长公共前缀 o = new 最长公共前缀();
        String [] strs = {"flower","flow","flowight"};
        Asserts.test(o.longestCommonPrefix(strs).equals("flow"));
        String [] strs1 = {"a","b"};
        Asserts.test(o.longestCommonPrefix(strs1).equals(""));

    }
}

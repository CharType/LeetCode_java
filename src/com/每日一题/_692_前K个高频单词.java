package com.每日一题;

import java.util.*;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * 注意：
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * <p>
 * 扩展练习：
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _692_前K个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        // 取出现次数最多的前k个字符串
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0) return list;
        // 统计字符出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Integer number = map.get(word);
            if (number == null) {
                map.put(word, 1);
            } else {
                map.put(word, ++number);
            }
        }

        PriorityQueue<Model> queue = new PriorityQueue<Model>(words.length, new Comparator<Model>() {
            @Override
            public int compare(Model o1, Model o2) {
                if (o2.number != o1.number) {
                    return o2.number - o1.number;
                } else {
                    return o1.word.compareToIgnoreCase(o2.word);
                }
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Model model = new Model(entry.getKey(), entry.getValue());
            queue.add(model);
        }
        // 一遍遍历 O(n) 空间O(n)
        while (k > 0) {
            list.add(queue.remove().word);
            k--;
        }

        return list;
    }

    public static void main(String[] args) {
        _692_前K个高频单词 o = new _692_前K个高频单词();
//        String [] words = {"i", "love", "leetcode", "i", "love", "coding"};
//        System.out.println(o.topKFrequent(words,2).toString());
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(o.topKFrequent(words, 4).toString());
    }

}

class Model {
    String word;
    Integer number;

    Model(String word, Integer number) {
        this.word = word;
        this.number = number;
    }
}

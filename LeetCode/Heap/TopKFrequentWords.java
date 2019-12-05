package LeetCode.Heap;

import java.util.*;

/**
 * 692. Top K Frequent Words
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length < k) {
            return res;
        }

        Map<String, Integer> map  = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> a.getKey() == b.getKey() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while (res.size() < k) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
//        List<String> list = Arrays.asList(words);
        topKFrequent(words, 2);
    }
}

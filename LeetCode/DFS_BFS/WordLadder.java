package LeetCode.DFS_BFS;

import java.util.*;

/**
 * bfs  参考花花酱的video
 * time: O(n * 26^l)
 * space: O(n)
 *
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null)
            return 0;
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        queue.offer(beginWord);

        int level = 1;
        int curNum = 1;  // the candidate num on current level 同一层有几个词符合标准
        int nextNum = 0;  // 通过一次变换可以得到几个词
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                char[] curWord = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    curWord[i] = j;
                    String temp = new String(curWord);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return level + 1;
                        }
                        nextNum++;
                        queue.add(temp);
                        set.remove(temp);
                    }
                }
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }


    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null)
            return 0;
        Set<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] word = queue.poll().toCharArray();
                for (int j = 0; j < word.length; j++) {
                    char temp = word[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        word[j] = k;
                        String cur = new String(word);
                        if (set.contains(cur)) {
                            if (cur.equals(endWord)) {
                                return level + 1;
                            }
                            set.remove(cur);
                            queue.offer(cur);
                        }
                        word[j] = temp;
                    }
                }
            }
            level++;
        }
        return 0;
    }


}

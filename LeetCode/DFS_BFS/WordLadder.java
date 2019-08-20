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
        int curNum = 1;  // the candidate num on current level
        int nextNum = 0;  // counter for next level
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


}

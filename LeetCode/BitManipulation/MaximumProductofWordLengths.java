package LeetCode.BitManipulation;

/**
 * 318. Maximum Product of Word Lengths
 * 7/1/2019
 * bit manipulation
 * time: O(n ^2)
 * space: O()
 *
 * 思路：
 * 设定一个记录word长度的数组 将每个字符换成二进制数字表示 用数组记录每个字符是否出现过
 * 然后将两个word string进行相与 如果结果为0则证明两个字符串没有重合数字 可以进行计算
 * 1 << 0  00001   a
 * 1 << 1  00010   b
 * 1 << 2  00100   c
 * 以此类推
 */

public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int res = 0;
        int[] bytes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            bytes[i] = val;              // 记录了当前string 每个字符出现的状况
        }
        for (int i = 0; i < bytes.length; i++) {
            for (int j = i + 1; j < bytes.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) {                 // 注意这里 & 两边的是整形数，因此需要加括号
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}

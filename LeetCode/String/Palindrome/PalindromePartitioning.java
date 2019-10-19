package LeetCode.String.Palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * 6/29/2019
 * backtracking
 * 需要二遍复习
 * list. remove 是干啥？
 * list.add 为何？
 *
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    if (s == null || s.length() == 0)
        return res;
    helper(s, res, new ArrayList<>());
    return  res;
    }

    //helper函数的作用： 分割s，判断s的子字符串是否是回文， 如果是则加入list， 不是则删减？？
    public void helper(String s, List<List<String>> res, List<String> list) {
        if (s == null || s.length() == 0) {
            res.add(new ArrayList<>(list));
            // 要返回一个带有空数组的数组，这是因为当子串就是原字符串s的时候，而是还是个回文串，
            // 那么后面部分就为空了，若我们对空串调用递归返回的是一个空数组，那么就无法对其进行遍历，则当前的回文串就无法加入到结果res之中
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                list.add(s.substring(0, i + 1));
                helper(s.substring(i + 1), res, list);
                //通过tc测试，如果不将最后一个元素remove， 每次递归都会加上上次的结果 出现重复
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }


}

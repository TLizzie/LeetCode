package LeetCode.String;

import java.util.HashMap;

/**
 * 205. Isomorphic Strings
 * 6/23/2019
 *
 */
public class IsomorphicStrings {
    /**
     * 1. 判断ab是否在map中 如果在 a->b 继续
     * 2. a !-> b false
     * 3. 不在 b是否在 在 b->a true
     * 4. 不在 放进去
     * time : O(n2)
     * space: O(1) hashmap 只存256个字母
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null)
            return true;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b)) continue;
                else return false;
            } else {
                if (!map.containsValue(b))
                    map.put(a, b);
                else return false;
            }
        }
        return true;

    }

    public boolean isIsomorphic2(String s, String t) {
    //counting sort
        /**
         * 根据一对一映射的特点，我们需要用两个哈希表分别来记录原字符串和目标字符串中字符出现情况，
         * 由于ASCII码只有256个字符，所以我们可以用一个256大小的数组来代替哈希表，并初始化为0
         * 遍历原字符串，分别从源字符串和目标字符串取出一个字符，然后分别在两个哈希表中查找其值，
         * 若不相等，则返回false，
         * 若相等，将其值更新为i + 1，因为默认的值是0，所以我们更新值为i + 1，这样当 i=0 时，则映射为1，如果不加1的话，那么就无法区分是否更新了，
         */
        if (s == null || t == null)
            return true;
        int[] sChar = new int[256];
        int[] tChar = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (sChar[s.charAt(i)] != tChar[t.charAt(i)]) {
                return false;
            }
            sChar[s.charAt(i)] = i + 1;
            tChar[t.charAt(i)] = i + 1;
        }
        return true;
    }
}

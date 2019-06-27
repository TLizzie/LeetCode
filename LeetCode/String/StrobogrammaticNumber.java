package LeetCode.String;

import java.util.HashMap;

/**
 * 246.Strobogrammatic Number
 * 6/26
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * Input:  "69"
 * Output: true
 *
 * Input:  "962"
 * Output: false
 *
 * 思路： 利用回文的性质建立哈希表，找到对应关系
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left)))
                return false;
            if (map.get(num.charAt(left)) != num.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

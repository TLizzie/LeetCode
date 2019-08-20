package LeetCode.Array;

/**
 * Leetcode 169 Majority Element
 * Moore Voting Algorithm
 *
 */

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                res = num;
                break;
            }
        }
        return res;
    }

    //Moore Voting Algorithm
    //每次找出一对不相同的元素 从数组中删除掉 直到数组为空或者只剩下一个元素
    //如果存在元素e的频数超过半数 那么剩下的元素就是e

    public int majorityElement2(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (num != res) {
                count--;
            } else {
                count++;
            }
        }
        return res;
    }
}

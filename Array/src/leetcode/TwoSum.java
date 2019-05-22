package leetcode;

import java.util.HashMap;

/**
 * Leetcode 1 Two Sums
 * 看到寻找两个数组的关系 联想到hashmap 对于此类题的基本解法
 * 返回值是数字的index 那么key值是加数， value 是 index的值
 *
 * 函数：
 * boolean containsKey(key): Returns true if this map contains a mapping for the specified key.
 * 遍历数组
 *
 * time: O(n)
 * space: O(n) hashmap 存储
 */


public class TwoSum {
    public static int[] TwoSum(int[] nums, int target){
        if (nums.length < 2 || nums == null) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}

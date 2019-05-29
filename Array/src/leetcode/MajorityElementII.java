package leetcode;

import java.util.*;

/**
 * Leetcode 229 Majority Element II
 * 2019/5/29
 * Hashmap 理解
 * Hashset 存储无序 重复数据
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : map.keySet()) {
            if (map.get(num) > nums.length / 3) {
                res.add(num);
            }
        }
        return res;
    }

    public List<Integer> majorityElement2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > nums.length / 3) {
                res.add(num);
            }
        }
        return new ArrayList(res);
    }

    public List<Integer> majorityElement3(int[] nums){}

}

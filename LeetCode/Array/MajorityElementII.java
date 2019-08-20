package LeetCode.Array;

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

    public List<Integer> majorityElement3(int[] nums){
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int number1 = 0, number2 = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            } else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }

        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(number1);
        }
        if (count2 > nums.length / 3) {
            res.add(number2);
        }

        return res;

    }

}

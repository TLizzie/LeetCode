package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {

    //time: O(n!)  space: O(n)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length)
            res.add(new ArrayList<>(list));

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            list.add(nums[i]);
            used[i] = true;
            helper(res, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }


    // time : O(n!) space : O(n);
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        helper2(res, nums, 0);
        return res;
    }

    public void helper2(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (isUsed(nums,start, i)) continue;
            swap(nums, start, i);
            helper2(res, nums, start + 1);
            swap(nums, start, i);
        }

    }

    public boolean isUsed(int[] nums, int i, int j) {
        for (int x = i; x < j; x++) {
            if (nums[x] == nums[j])
                return true;
        }
        return false;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package LeetCode.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 设计list将index存起来
 * 然后再list里面随机抽取
 * 398. Random Pick Index
 * 7/20/2019
 *
 */
public class RandomPickIndex {
    int[] nums;
    Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) list.add(i);
        }
        return list.get(random.nextInt(list.size()));

    }

    /**
     * 蓄水池抽取法 数据流的想法
     * 第一个符合条件的元素总是被选择
     * 非常常用 背下来
     * @param target
     * @return
     */
    public int pick2(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            count++;
            if (random.nextInt(count) == 0)
                res = i;
        }
        return res;
    }
}

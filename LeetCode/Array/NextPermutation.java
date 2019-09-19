package LeetCode.Array;

import java.util.Arrays;

/**
 * 31.  Next Permutation
 *
 * 从上面的某一行重排到期下一行，如果已经是最后一行了，则重排成第一行。
 * 这里，先考虑一个序列的最大最小情况。当一个序列为非递减序列时，它必然是该组数的最小的排列数；同理，当一个序列为非递增序列时，它必然是该组数的最大的排列数。
 *
 * 1 2 3  √
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 *
 *[1 2 6 4 2] -> [1 4 2 2 6]
 *
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int replace = nums.length - 2;
        while(replace >= 0) {
            if (nums[replace] < nums[replace + 1]) {
                break;
            }
            replace--;
        }

        if (replace < 0) {
            Arrays.sort(nums);
            return;
        }
        int index = replace + 1;
        while (index < nums.length && nums[index] > nums[replace]) {
           index++;
        }
        int temp = nums[replace];
        nums[replace] = nums[index - 1];
        nums[index - 1] = temp;
        Arrays.sort(nums, replace + 1, nums.length);

    }
}

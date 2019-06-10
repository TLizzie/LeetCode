package Array.src.leetcode;

/**
 * Leetcode 75
 * 6/9/2019
 * follow up很多 很重要的一道题
 */
public class SortColors {
    //难得自己写出来一个
        public void sortColors(int[] nums) {
            int red = 0;
            int white = 0;
            int blue = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    red++;
                } else if (nums[i] == 1) {
                    white++;
                } else if (nums[i] == 2) {
                    blue++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (i < red) {
                    nums[i] = 0;
                } else if (i >= red && i < red + white) {
                    nums[i] = 1;
                } else if (i >= red + white) {
                    nums[i] = 2;
                }
            }
        }

    /**
     * 思想： 0 放到前面，1位置不变，2放到后面
     * index 和 right 交换+1 是因为有可能是[2,0] 交换 因此index位置还需要是否和
     * @param nums
     */
    public void sortColors2(int[] nums) {
            if (nums.length == 0 || nums == null) return;
            int left = 0;
            int right = nums.length - 1;
            int index = 0;
            while (index <= right) {
                if (nums[index] == 0) {
                    swap(nums, index++, left++);
                } else if (nums[index] == 1) {
                    index++;
                } else {
                    swap(nums, index, right--);
                }
            }

    }
    public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
}

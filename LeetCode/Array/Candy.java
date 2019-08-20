package LeetCode.Array;

import java.util.Arrays;

/**
 * Leetcode 135 candy
 * 6/10/2019
 * 基础题
 * time: O(n)
 * space: O(n)
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i : candy) {
            sum += i;
        }
        return sum;
    }
}

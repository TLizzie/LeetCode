package leetcode;

import Array.Array;

import java.util.Arrays;

/**
 * Leetcode 274 H-Index
 *
 * time: O(nlogn)
 * space: O(1)
 *
 * time: O(n)
 * space: O(n)
 */


public class hIndex {

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        while (res < citations.length && citations[citations.length - 1 - res] > res) {
            res++;
        }
        return res;
    }

    public static int hIndex2(int[] citations) {
        int len = citations.length;
        int[] count = new int[citations.length + 1];            //加一个0位
        for (int c : citations) {
            if (c > len) {
                count[len]++;
            }   else {
                count[c]++;
            }
        }

        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;

    }
}

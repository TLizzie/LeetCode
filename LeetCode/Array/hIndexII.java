package LeetCode.Array;

/**
 * Leetcode 275
 * 2019/5/23
 * 看到sorted array 联想到二分查找
 * 前一个题同样方法也可以做
 * 问题的核心： citations[index] >= len - index
 */
public class hIndexII {
    public static int Index(int[] citations) {
        int len = citations.length;
        int start = 0, end = len - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] < len - mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return len - start;

    }
}

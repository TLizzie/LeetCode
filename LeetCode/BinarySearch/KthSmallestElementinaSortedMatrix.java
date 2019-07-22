package LeetCode.BinarySearch;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * 7/17/2019
 * binary search
 * priority queue
 */
public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            int num = count(matrix, mid);           //计算小于mid的元素数目
            if (num >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (count(matrix, end) <= k - 1) {
            return end;
        }
        return start;
    }

    private int count(int[][] nums, int target) {
        int i = nums.length - 1;
        int j = 0;
        int res = 0;
        while (i >= 0 && j < nums.length) {
            if (nums[i][j] < target) {
                res += i + 1;                       // 从n - 1变成n
                j++;
            } else {
                i--;
            }
        }
        return res;
    }
}

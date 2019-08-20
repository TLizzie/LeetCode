package LeetCode.Array;

import Array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  56. MergeIntervals
 *  7/10/2019
 *
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[][]{};

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval :intervals) {
            if (interval[0] <= end) {
                end = Math.max(interval[1], end);
            } else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        res.add(new int[]{start, end});
        return res.toArray(new int[][]{});
    }
}

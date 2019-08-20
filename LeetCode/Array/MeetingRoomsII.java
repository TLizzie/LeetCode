package LeetCode.Array;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;

/**
 * 253.Meeting Rooms II
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 *
 * 扫描线算法
 */
class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        //  一定会有的排序
        Arrays.sort(starts);
        Arrays.sort(ends);

        int end = 0;
        int res = 0;

        // 扫描区间 碰到上一个区间结束 则end前进一个元素
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else {
                end++;
            }
        }
        return res;
    }

}


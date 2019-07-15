package Array.src.leetcode;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;

/**
 * 252.Meeting Rooms
 * 7/9/2019
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * Example 1:
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 *
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: true
 *
 *  time: O(nlogn)
 *  space: O(n)
 */
class MeetingRooms {

    public boolean canAttendMeetings(Interval intervals) {
        @Override
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1;  i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start)
                return false;
        }
        return true;
    }
}

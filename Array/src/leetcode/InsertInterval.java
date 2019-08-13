package Array.src.leetcode;

import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 * 7/10/2019
 *
 */

//   public class Interval {
////        int start;
//        int end;
//
//        Interval() {
//            start = 0;
//            end = 0;
//        }
//
//        Interval(int s, int e) {
//            start = s;
//            end = e;
//        }
//    }

    public class InsertInterval {
        public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
            if (newInterval == null)
                return intervals;
            List<Interval> res = new ArrayList<>();
            int i = 0;
            while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
                res.add(intervals.get(i++));
            }
            while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            }
            res.add(newInterval);
            while (i < intervals.size())
                res.add(intervals.get(i));
            return res;
        }

        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> res = new ArrayList<>();
            int i = 0;
            while (i < intervals.length && newInterval.start >= intervals[i][0]) {
                res.add(intervals[i]);
                i++;
            }
            while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            res.add(newInterval);
            while (i < intervals.length) {
                res.add(intervals[i++]);
            }
            return res.toArray(new int[][]{});
        }


}

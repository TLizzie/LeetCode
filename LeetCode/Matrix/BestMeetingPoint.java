package LeetCode.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 296.Best Meeting Point
 * 7/12/2019
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 * 1. 降维
 * 2. 只要mt在两个点之间就可以得到最短Manhattan距离
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    J.add(j);
                }
            }
        }

        return min(I) + min(J);
    }

    public int min(List<Integer> list) {
        int i = 0, j = list.size();
        int sum = 0;
        while (i < j) {
            sum += list.get(j--) + list.get(i++);
        }
        return sum;
    }
}

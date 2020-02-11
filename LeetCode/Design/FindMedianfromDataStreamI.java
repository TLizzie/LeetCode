package LeetCode.Design;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindMedianfromDataStreamI {
    
    private ArrayList<Integer> list;
    
    public FindMedianfromDataStreamI() {
        this.list = new ArrayList<>();
    }
    
    private int findIndex(int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    

    public void addNum(int num) {
        if (list.size() == 0) {
            list.add(num);
        } else {
            int index = findIndex(num);
            if (index == list.size()) {
                list.add(num);
            } else {
                list.add(index, num);
            }
        }
    }
    

    public double findMedian() {
        int mid = (list.size() - 1) / 2;
        if (list.size() % 2 == 0) {
            return list.get(mid);
        }
        return (list.get(mid) + list.get(mid + 1)) / 2.0;
    
    }
}

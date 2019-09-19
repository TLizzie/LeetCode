package LeetCode.BinarySearch;

import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();
        if (arr == null || arr.length == 0)
            return res;
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            return res;
        }

        if (x >= arr[arr.length - 1]) {
            for (int i = 0; i < k; i++) {
                res.addFirst(arr[arr.length - k - 1 + i]);
            }
            return res;
        }
        return res;
    }
}

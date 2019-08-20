package LeetCode.Design;

/**
 * 加入数字 使用list使用O(1)的时间复杂度
 * data -> (list) index
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class InsertDeleteGetRandomDuplicatesallowed {

    HashMap<Integer, HashSet<Integer>> map;
    Random rmd;
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomDuplicatesallowed() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rmd = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, val);
            map.get(val).remove(index);
            map.get(val).add(lastVal);
        }
        return true;

    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}

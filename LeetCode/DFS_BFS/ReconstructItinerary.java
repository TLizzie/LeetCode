package LeetCode.DFS_BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {

    HashMap<String, PriorityQueue<String>> map;
    List<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        this.map = new HashMap<>();
        this.res = new LinkedList<>();

        for (int i = 0; i < tickets.size(); i++) {

            // pq 按照字母进行排序 无需重写
            map.computeIfAbsent(tickets.get(i).get(0), k -> new PriorityQueue<>()).add(tickets.get(i).get(1));
        }
        helper("JFK");
        return res;
    }

    public void helper(String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            helper(map.get(airport).poll());
        }

        // recursion 反向加入结果
        res.add(0, airport);
    }

}

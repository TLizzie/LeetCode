package LeetCode.Graph;

import java.util.*;

/**
 * 133. Clone Graph
 * 这个题没写对 需要再看
 * ？？
 *
 */

public class CloneGraph {

    public Node cloneGraph(Node node) {
        return bfsHelper(node);
    }

    public Node bfsHelper(Node node) {
        if (node == null) {
            return node;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            map.get(cur).neighbors = new ArrayList<>();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(node.val));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }


}

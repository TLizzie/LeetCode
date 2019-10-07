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

        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, null);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            map.put(cur, new Node(cur.val, new ArrayList<>()));
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, null);
                    queue.offer(neighbor);
                }
            }
        }

        for (Node original : map.keySet()) {
            Node copy = map.get(original);
            for (Node nei : original.neighbors) {
                copy.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }

    public Node cloneGraph2(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}

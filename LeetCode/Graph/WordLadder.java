package LeetCode.Graph;

/**
 *  图的转换思想
 */

import java.util.*;

public class WordLadder {

    public int wordLadder(String beginWord, String endWord, List<String> wordList) {
        Graph graph = new Graph();
        for (String word : wordList) {
            graph.addNodes(new Node(word));
        }
        if (!wordList.contains(beginWord)) {
            graph.addNodes(new Node(beginWord));
            wordList.add(beginWord);
        }

        for (String word:  wordList) {
            Node node = graph.getNode(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <='z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (graph.getNode(temp) != null && !node.neighbors.contains(temp) && !temp.equals(word)) {
                        node.neighbors.add(graph.getNode(temp));
                    }
                }
            }
        }

        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        set.add(graph.getNode(beginWord));
        queue.offer(graph.getNode(beginWord));

        int res = 0;

        while(!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                if (node.word.equals(endWord)) {
                    return res;
                }
                for (Node neighbor : node.neighbors) {
                    if (!set.contains(neighbor)) {
                        set.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return 0;
    }



    class Graph {
        List<Node> nodes;
//        Integer 存贮index
        HashMap<String, Integer> map;

        public Graph() {
            this.nodes = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public void addNodes(Node node) {
            map.put(node.word, nodes.size());
            nodes.add(node);
        }

        public Node getNode(String word) {
            if (map.containsKey(word)) {
                return nodes.get(map.get(word));
            }
            return null;
        }
    }


    class Node {
        String word;
        List<Node> neighbors;

        public Node(String word) {
            this.word = word;
            this.neighbors = new ArrayList<>();
        }
    }
}

package LeetCode.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II
 *
 * Trie: oath: o--a--t--h
 *                      oath
 *
 *[
 *  ['o','a','a','n'],
 *  ['e','t','a','e'],
 *  ['i','h','k','r'],
 *  ['i','f','l','v']
 * ]
 *
 * [
     ['#','#','a','n'],
     ['e','#','a','e'],
     ['i','#','k','r'],
     ['i','f','l','v']
 * ]
 *
 *  time : O(m * n * TrieNode)
 *  space : TrieNode
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String str : words) {
            TrieNode p = root;
            for (char c : str.toCharArray()) {
                int i = c - 'a';
                if (p.children[i] == null) {
                    p.children[i] = new TrieNode();
                }
                p = p.children[i];
            }
            p.word = str;
        }
        return root;
    }

    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)    return;
        char c = board[i][j];
        if (c == '#' || root.children[c - 'a'] == null) return;
        root = root.children[c - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, root, res);
        dfs(board, i + 1, j, root, res);
        dfs(board, i, j + 1, root, res);
        dfs(board, i , j - 1, root, res);
        board[i][j] = c;
    }
}

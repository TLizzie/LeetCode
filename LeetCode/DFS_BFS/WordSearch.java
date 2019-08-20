package LeetCode.DFS_BFS;

public class WordSearch {

    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        if (board == null || board[0].length == 0)
            return true;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int i, int j, int start) {
        if (start >= word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n)     return false;
        if (board[i][j] == word.charAt(start++)) {
            char c = board[i][j];
            board[i][j] = '#';
            boolean res = exist(board, word, i + 1, j, start) || exist(board, word, i - 1, j, start)
                    || exist(board, word, i, j - 1, start) || exist(board, word, i, j + 1, start);

            board[i][j] = c;
            return res;
        }
        return false;
    }

}

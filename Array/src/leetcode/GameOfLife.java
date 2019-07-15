package Array.src.leetcode;

/**
 * 289. Game of Life
 * 7/12/2019
 * 位运算 然后进行右移
 * 00 10  -> 01
 * 01 11  -> 01
 *
 * 00 00  -> 00
 */

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = count(board, i, j);
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;
                    }
                } else if (count == 3) {
                    board[i][j] += 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
        return;
    }

    private int count(int[][] board, int i, int j) {
        int count = 0;
        for (int row = Math.max(0, i - 1); row <= Math.min(i + 1, board.length - 1); row++) {
            for (int col = Math.max(0, j - 1); col <= Math.min(j + 1, board[0].length - 1); col++) {
                if (row == i && col == j)
                    continue;
                if ((board[row][col] & 1) == 1)
                    count++;
            }
        }
        return count;
    }

}

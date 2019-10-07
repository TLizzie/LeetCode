package LeetCode.DFS_BFS;

public class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (click.length < 2) {
            return board;
        }
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') {
            return;
        }
        int mines = findMines(board, x, y);
        if (mines == 0) {
            board[x][y] = 'B';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    dfs(board, x + i, y + j);
                }
            }
            return;
        } else {
            board[x][y] = (char)('0' + mines);
        }
    }

    public int findMines(char[][] board, int x, int y) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i < 0 || y + j < 0 || x + i >= board.length || y + j >= board[0].length) {
                    continue;
                }
                if (board[x + i][y + j] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}

package org.example;

public class SudokuSolver3 {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // reach the last column, next row
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            // reach the last row, finish
            return true;
        }

        if (board[i][j] != '.') {
            // preset number, skip
            return backtrack(board, i, j + 1);
        }
        // if board[i][j] == '.'
        for (char ch = '1'; ch <= '9'; ch++) {
            // conflict with others, skip
            if (!isValid(board, i, j, ch))
                continue;

            board[i][j] = ch;
            // have found a solution, stop
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        // for this grid, 1~9 all fail
        return false;
    }

    boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // row
            if (board[r][i] == n) return false;
            // column
            if (board[i][c] == n) return false;
            // 3 x 3
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;
    }
}

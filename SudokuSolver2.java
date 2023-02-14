package org.example;

public class SudokuSolver2 {
    public void solveSudoku(char[][] board) {
        doSolve(board, 0);
    }

    private boolean doSolve(char[][] board, int serial) {
        int i = serial / 9;
        int j = serial % 9;
        if(serial>80) return true;
        if (board[i][j] == '.')
        {
            for (char num = '1'; num <= '9'; num++)
            {
                if (isValid(board, i, j, num))
                {
                    board[i][j] = num;
                    if (doSolve(board, serial + 1)) // Vừa dùng làm if statement vừa vừa dùng để recursive
                        return true;
                    board[i][j] = '.';
                }
            }
            return false;
        }
        else
            return (doSolve(board, serial + 1));
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++)
            if (board[i][col] == num || board[row][i] == num ||
                    board[blkrow + i / 3][blkcol + i % 3] == num)
                return false;
        return true;
    }
}

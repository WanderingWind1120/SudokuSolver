package org.example;

public class SudokuSolver1 {
    public void solveSudoku(char[][] board) {
        doSolve(board, 0, 0);
    }

    private boolean doSolve(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) { // note: must reset col here!
            // loop theo chiều dọc
            for (int j = col; j < 9; j++) { // nested loop theo chiều ngang bằng đầu từ col được pass in vào method
                if (board[i][j] != '.') continue; // các ô đã có số trong ma trận thì  skip
                for (char num = '1'; num <= '9'; num++) { // loop các giá trị có thể điền vào ô chưa có giá trị đang loop tới nơi
                    if (isValid(board, i, j, num)) { // Nếu tại cái ô trống này hàng, cột, inner board chứa nó đều không có ô
                        // nào chứa giá trị num thì gán giá trị num cho ô hiện tại
                        board[i][j] = num;
                        if (doSolve(board, i, j + 1))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
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

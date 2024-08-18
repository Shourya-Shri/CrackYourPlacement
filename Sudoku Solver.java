class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') { // Empty cell found
                    for (char digit = '1'; digit <= '9'; digit++) { // Try digits 1-9
                        if (isSafe(board, row, col, digit)) {
                            board[row][col] = digit;
                            if (solve(board)) { // Recur to check if this leads to a solution
                                return true;
                            }
                            board[row][col] = '.'; // Backtrack if no solution is found
                        }
                    }
                    return false; // No valid digit leads to a solution
                }
            }
        }
        return true; // All cells are filled correctly
    }
    
    private boolean isSafe(char[][] board, int row, int col, char digit) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) {
                return false;
            }
        }
        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }
        // Check the 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
}

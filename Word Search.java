class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        // Base case: If all characters in the word are found
        if (k == word.length()) {
            return true;
        }
        
        // Check if current position is out of bounds or the character doesn't match
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        
        // Mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '*';
        
        // Explore adjacent cells in all four directions
        boolean result = dfs(board, word, i + 1, j, k + 1) ||
                         dfs(board, word, i - 1, j, k + 1) ||
                         dfs(board, word, i, j + 1, k + 1) ||
                         dfs(board, word, i, j - 1, k + 1);
        
        // Restore the original value of the current cell
        board[i][j] = temp;
        
        return result;
    }
}

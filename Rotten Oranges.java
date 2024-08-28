class Solution {
    // Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid) {
        int n = grid.length; // Number of rows in the grid
        int m = grid[0].length; // Number of columns in the grid
        int count = 0; // This variable counts the number of time units passed
        int f = 0; // Flag to check if any fresh oranges have been rotted in the current time unit
        
        while (true) {
            f = 0; // Reset the flag for the current round
            
            // Traverse the grid to find rotten oranges and spread rot to adjacent fresh oranges
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 2) {
                        // Check right
                        if (j < m - 1 && grid[i][j + 1] == 1) { 
                            grid[i][j + 1] = -1; 
                            f = 1;
                        }
                        // Check down
                        if (i < n - 1 && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = -1; 
                            f = 1;
                        }
                        // Check left
                        if (j > 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = -1; 
                            f = 1;
                        }
                        // Check up
                        if (i > 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = -1; 
                            f = 1;
                        }
                    }
                }
            }
            
            // Update grid after each round
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == -1) {
                        grid[i][j] = 2;
                    }
                }
            }

            // If no fresh oranges turned rotten, break out of the loop
            if (f == 0) break;

            // Increment the time counter
            count++;
        }

        // Check if any fresh oranges are left
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return count;
    }
}

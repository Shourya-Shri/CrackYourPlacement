class Solution {
    public int swimInWater(int[][] grid) {        
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], maxDepth = current[2];
            
            // If the current cell is already visited, skip it
            if (visited[x][y]) continue;
            
            // Mark the current cell as visited
            visited[x][y] = true;
            
            // If we've reached the bottom-right corner, return the max depth
            if (x == n - 1 && y == n - 1) {
                return maxDepth;
            }
            
            // Explore the four possible directions
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                
                if (newX >= 0 && newY >= 0 && newX < n && newY < n && !visited[newX][newY]) {
                    pq.offer(new int[]{newX, newY, Math.max(maxDepth, grid[newX][newY])});
                }
            }
        }
        
        // Return 0 as a fallback, though we expect to always return from the loop
        return 0;
    }
}

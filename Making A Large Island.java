//DFS

import java.util.*;

class Solution {
    private int islandId = 2;
    private Map<Integer, Integer> islandAreas = new HashMap<>();
    private int[] rowP = {-1, 0, 0, 1}; // up, left, right, down
    private int[] colP = {0, -1, 1, 0};

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        // Label all islands and compute their areas using DFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int islandArea = dfs(grid, i, j);
                    islandAreas.put(islandId, islandArea);
                    islandId++;
                }
            }
        }

        int maxArea = 0;
        // Check each cell to find the maximum area of an island formed by changing that cell from 0 to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    int area = 1; // Start with the current cell
                    Set<Integer> surrounding = new HashSet<>();
                    for (int d = 0; d < rowP.length; d++) {
                        int newI = i + rowP[d], newJ = j + colP[d];
                        if (newI >= 0 && newI < n && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] != 0) {
                            surrounding.add(grid[newI][newJ]);
                        }
                    }
                    for (int id : surrounding) {
                        area += islandAreas.getOrDefault(id, 0);
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea > 0 ? maxArea : n * n;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = islandId;
        int area = 1;
        for (int d = 0; d < rowP.length; d++) {
            area += dfs(grid, i + rowP[d], j + colP[d]);
        }
        return area;
    }
}

// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

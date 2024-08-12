class Solution {
    
    ArrayList<String> ans = new ArrayList<>();

    void solve(int i, int j, int n, int m, String s, int[][] vis, int[][] mat) {
        // Base Case
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] == 1 || mat[i][j] == 0) {
            return;
        }
        if(i == n-1 && j == m-1) {
            ans.add(s);
            return;
        }

        // Mark as visited
        vis[i][j] = 1;
        
        // Recursive Case
        solve(i+1, j, n, m, s+'D', vis, mat); // Move Down
        solve(i, j+1, n, m, s+'R', vis, mat); // Move Right
        solve(i-1, j, n, m, s+'U', vis, mat); // Move Up
        solve(i, j-1, n, m, s+'L', vis, mat); // Move Left
        
        // Unmark the current cell
        vis[i][j] = 0;
    }

    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if(mat[0][0] == 0) {
            ArrayList<String> result = new ArrayList<>();
            result.add("-1");
            return result;
        }
        
        int[][] vis = new int[n][m];
        solve(0, 0, n, m, "", vis, mat);
        
        if (ans.isEmpty()) {
            ans.add("-1");
        }
        
        return ans;
    }
}

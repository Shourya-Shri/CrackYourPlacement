class Solution {
    public int maxDistance(int[][] grid) {
         int m =  grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList();
        int directions[][] = new int[][]{{-1, 0}, {1,0}, {0, 1}, {0, -1}};
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    q.add(new int[]{i, j});
            }
        }
        
        if(q.size() == (m * n)) return -1;
        int level = 0;
            
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++){
                int[] temp = q.remove();
                int row = temp[0];
                int col = temp[1];
                for(int[] dir : directions){
                    int cr = row + dir[0];   //current row
                    int cc = col + dir[1];   //current col
                    if(cr >= 0 && cr < m && cc >=0 && cc < n && grid[cr][cc] == 0){
                       grid[cr][cc] = 1;
                       q.add(new int[]{cr, cc});
                    } 
                }  
            }
        }
        return level - 1;
    }
}

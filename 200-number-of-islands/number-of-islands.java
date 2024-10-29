class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                  bfs(grid, i, j, visited);
                  island += 1;
                }
            }
        }
        return island;
    }

    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {        
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        while(!q.isEmpty()){
            int[] current = q.poll();
            int row = current[0], col = current[1];
            
            for (int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Check boundaries, if it's land ('1') and not visited
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length &&
                    grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                    q.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true; 
                    // mark as visited then we dont visited twice
                }
            }

        }  
    }
}